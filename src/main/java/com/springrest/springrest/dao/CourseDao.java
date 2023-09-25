package com.springrest.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.springrest.entites.Courses;
import com.springrest.springrest.dao.*;

public interface CourseDao extends JpaRepository<Courses, Long> {

	

}
