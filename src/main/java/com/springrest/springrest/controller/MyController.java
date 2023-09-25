package com.springrest.springrest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entites.Courses;
import com.springrest.springrest.services.CourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController   
public class MyController {
	
	@Autowired 
	private CourseService courseService;
	
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to courses application";
		
	}
//=======================================================================	
   // get the courses 
	// all the data course 
	@GetMapping("/courses")
	
	 public List <Courses> getCourses()
	{
	return this.courseService.getCourses();	 
} 
	//========================================================================
	// find the course as per id  
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId)
	{
	return	this.courseService.getCourse(Long.parseLong(courseId));
	}
//=========================================================================
	//Add course to the data
@PostMapping("/courses")	
   public Courses addCourse(@RequestBody Courses course)
   {
	return this.courseService.addCourse(course);
}
//===============================================================================
 // update the data
@PutMapping("/courses")
public Courses putCourse(@RequestBody Courses course)
{
	return this.courseService.updateCourse(course);
}
//=================================================================================

@DeleteMapping("/courses/{courseId}")
public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
	try {
		this.courseService.deleteCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		
	}catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	 }

}
}
