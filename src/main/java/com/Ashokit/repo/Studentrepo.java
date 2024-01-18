package com.Ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ashokit.entity.Student;


@Repository
public interface Studentrepo extends JpaRepository<Student, Integer> {

	public List<Student>  findByCid(Integer cid);


	
}
