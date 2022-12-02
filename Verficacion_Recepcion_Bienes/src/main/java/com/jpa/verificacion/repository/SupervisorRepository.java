package com.jpa.verificacion.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.verificacion.entity.Supervisor;



public interface SupervisorRepository extends JpaRepository<Supervisor, Integer>{

	
}
