package com.karnafully.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karnafully.model.Assignee;

public interface AssigneeRepo extends JpaRepository<Assignee, Long> {
	
	@Query("select a from Assignee a where a.name like :x")
	public Page<Assignee> search(@Param("x") String mc, Pageable pageable  );   
	
}
