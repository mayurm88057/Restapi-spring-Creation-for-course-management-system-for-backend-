package com.springrest.springrest.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entites.Courses;

@Service
public class CourseServiceimpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	// List<Courses> list;

	public CourseServiceimpl() {

		/*
		 * list=new ArrayList<>(); list.add(new Courses(
		 * 145,"java core","this is java coruse 1")); list.add(new
		 * Courses(111,"spring boot","the rest api"));
		 */
	}

	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
  
		
	}
	// return list; }

	@Override
	public Courses getCourse(long courseId) {
		/*
		 * Courses c = null; for (Courses course : list) { if (course.getId() ==
		 * courseId) { c = course; break; } }
		 * 
		 * return c;
		 */
		return courseDao.getOne(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
		//list.add(course);
		courseDao.save(course);
		return course;
	} 

	@Override
	public Courses updateCourse(Courses course) {
		/*
		 * list.forEach(e -> { if (e.getId() == course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * 
		 * });
		 */
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses deleteCourse(long parseLong) {
		/*
		 * list = this.list.stream().filter(e -> e.getId() !=
		 * parseLong).collect(Collectors.toList()); return null;
		 */
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
		return entity;
		
	}

}
