package com.blueradix.ws.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blueradix.ws.model.Login;
import com.blueradix.ws.model.Timetable;
import com.blueradix.ws.service.TimetableService;



@RestController
public class TimetableController extends BaseController{

	@Autowired
	TimetableService timetableService;
	
	@CrossOrigin
	@RequestMapping(
			value = "/timetable",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Timetable> getTimetable(@RequestBody Login login){
		
		logger.info("> getTimetable");
		Timetable timetable = timetableService.findByUserIdAndPassword(login.getUserId(), login.getPassword());
		logger.info("< getTimetable");
		
		logger.info(timetable.toString());
		
	
		
		if(timetable.getUsername().equals("Wrong Username or Password!"))
			return new ResponseEntity<Timetable>(timetable, HttpStatus.UNAUTHORIZED);
		else
			return new ResponseEntity<Timetable>(timetable, HttpStatus.OK);
		
	}
	

	

}
