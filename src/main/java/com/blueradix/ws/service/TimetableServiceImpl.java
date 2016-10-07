package com.blueradix.ws.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.blueradix.ws.model.TimeSlot;
import com.blueradix.ws.model.Timetable;


@Service
public class TimetableServiceImpl implements TimetableService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	WebDriver driver;
	private WebDriver driver;

	@Override
	public Timetable findByUserIdAndPassword(Long userId, String password){
		
		logger.info("> findByUserIdAndPassword");
		
		System.setProperty("webdriver.chrome.driver", "/Users/Alex/Documents/workTest/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");

		driver = new ChromeDriver();
		
		Timetable timetable = null;
		try{
			timetable = scrape(userId.toString(), password);
		}catch(Exception e){
			driver.close();
		}
		
		
		//logger.info(timetable.toString());
		logger.info("< findByUserIdAndPassword");
		
		return timetable;
	}
	
	private Timetable scrape(String userId, String password) {
		Timetable timetable = null;
		List<WebElement> searchResults = new ArrayList<WebElement>();
		driver.get("https://jivi.ait.nsw.edu.au/mobile/timetable.php");
		try {
			// WebElement form = driver.findElement(By.name("timetable"));
			WebElement idElement = driver.findElement(By.id("id"));
			idElement.sendKeys(userId.trim());
			WebElement idElement2 = driver.findElement(By.id("pw"));
			idElement2.sendKeys(password.trim());
			WebElement subElement = driver.findElement(By.id("hawinputsubmit"));
			subElement.click();
			// searchResults.addAll(driver.findElements(By.tagName("big"));
			/*
			 * searchResults = driver.findElements(By.tagName("big")); for(int i
			 * = 0; i < searchResults.size() ;i++){
			 * System.out.println(searchResults.get(i).getText()); }
			 * 
			 * searchResults = driver.findElements(By.id("hawtextbox")); for(int
			 * i = 0; i < searchResults.size() ;i++){
			 * System.out.println(searchResults.get(i).getText()); }
			 */
			searchResults = driver.findElements(By.id("canvas"));
//			for (int i = 0; i < searchResults.size(); i++) {
//				System.out.println(searchResults.get(i).getText());
//				
//			}
			
			
			String line;
			timetable = new Timetable(); 
			for(int j = 0; j < searchResults.size() ;j++){
				 line = searchResults.get(j).getText(); 
				 
				 List<String> myList = new ArrayList<String>(Arrays.asList(line.split("\n")));
				 String data = null;
				 
				 TimeSlot timeSlot = null;
				 Date date = null; 
				 for(int i =0; i < myList.size() ; i ++ ){
					 data = myList.get(i);
				 	 if( data.equals("")){
				 		 continue;
				 	 }
					 //System.out.println(data);
					 if(i==0){
						 int pos = data.indexOf(":");
						 if(pos > 0){
							 data = data.substring(pos + 1);
						 }
						 timetable.setUsername(data); 
						 continue; 
					 }
					 if(isDayLine(data)){
						 //transform the text into date
						 date = getDate(data);
						 continue; 
					 }
					 if(isSubjectClassroomLine(data)){
						 timeSlot = new TimeSlot();
						 timeSlot.setClassroom(getClassroom(data));
						 timeSlot.setSubject(getSubject(data));
						 continue;
					 }
					 if(isTimeLine(data)){
						 timeSlot.setStart(getStartDate(data, date));
						 timeSlot.setEnd(getEndDate(data, date));
						 List<TimeSlot> x =  timetable.getSlots();
						 x.add(timeSlot);
						 timetable.setSlots(x);
						 continue;
					 }
				 }
			}
			 
			
			System.out.println(timetable.toString());

			// techNews.forEach(n -> {
			// System.out.println(n.getText().get());
			// });

			/*
			 * searchResults.addAll(driver.findElements(By.xpath(
			 * "//a[contains(@class,'search-result-link')]")).stream() .map(a ->
			 * a.getText() + "->" +
			 * a.getAttribute("href")).collect(Collectors.toList()));
			 */
		} catch (NoSuchElementException e) {
			System.out.println("Element does not exist" + e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}
		return timetable;
	}

//	public static void main(String[] args) {
//		new SeleniumExample().scrape();
//
//	}

	private boolean isDayLine(String value) {
		boolean ret = false;
		List<String> days = new ArrayList<String>();
		days.add("Mon,");
		days.add("Tue,");
		days.add("Wed,");
		days.add("Thu,");
		days.add("Fri,");
		days.add("Sat,");
		days.add("Sun,");

		try {
			if (value.length() > 0) {

				if (days.contains(value.substring(0, 4)))
					ret = true;
			}
		} catch (Exception e) {

			ret = false;
		}
		return ret;

	}
	private boolean isSubjectClassroomLine(String value){
		return value.contains(" in ")? true: false ;
	}
	private boolean isTimeLine(String value){
		boolean ret = false;
		try{
			if( value.contains(":") && (value.contains(" pm-") || value.contains(" am-")) ){
				ret = true;
			}
		}catch (Exception e) {
			ret = false;
		}
		return ret;
	}
	
	private Date getDate(String stringDate) {
		Date date = null;
		String pattern = "E, dd-MM-yyyy";
		SimpleDateFormat sfd = new SimpleDateFormat(pattern);
		try {
			date = sfd.parse(stringDate);

		} catch (ParseException e) {
			date = null;
		}
		return date;
	}


	
	private Date getStartDate(String value, Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, getHourStartTime(value));
		cal.set(Calendar.MINUTE, getMinStartTime(value));
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		date = cal.getTime();

		return date;
	}

	private Date getEndDate(String value, Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, getHourEndTime(value));
		cal.set(Calendar.MINUTE, getMinEndTime(value));
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		date = cal.getTime();

		return date;
	}
	
	private String getSubject(String value){
		return getStringBeforeToken(value, " in ");
	}
	
	private String getClassroom(String value){
		return getStringAfterToken(value, " in ");
		
	}

	private String getStringBeforeToken(String value, String token) {
		int position = value.indexOf(token);
		return value.substring(0,position);
	}

	private String getStringAfterToken(String data, String token) {
		int position = data.indexOf(token);
		return data.substring(position + token.length());
	}
	
	private int getHour(String value){
		
		int ret, hour = 0;

		hour = Integer.parseInt(value.substring(0, 2));
		if(value.contains("pm")){
			ret = 12 + hour;
		}else{
			ret = hour;
		}
		return ret;
	}

	private int getMin(String value){
		return Integer.parseInt(value.substring(3, 5));
	}
	
	private int getHourStartTime(String value){
		String startTime = getStringBeforeToken(value, "-");
		return getHour(startTime);
	}
	private int getMinStartTime(String value){
		String startTime = getStringBeforeToken(value, "-");
		return getMin(startTime);
	}

	private int getHourEndTime(String value){
		String startTime = getStringAfterToken(value, "-");
		return getHour(startTime);
	}

	private int getMinEndTime(String value){
		String endTime = getStringAfterToken(value, "-");
		return getMin(endTime);
	}
	
}
