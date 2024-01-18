package com.Ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ashokit.entity.Counsellor;

@Repository
public interface Counsellorrepo extends JpaRepository<Counsellor, Integer> {

	public Counsellor findByEmail(String email);
	public Counsellor findByEmailAndPassword(String email,String password);
	
}
