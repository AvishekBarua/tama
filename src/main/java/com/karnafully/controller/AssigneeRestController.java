package com.karnafully.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karnafully.model.Assignee;
import com.karnafully.repository.AssigneeRepo;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "*")
public class AssigneeRestController {

	@Autowired
	private AssigneeRepo assigneeRepo;

	@RequestMapping(value = "/assignees", method = RequestMethod.GET)
	public List<Assignee> getAssignees() {
		return assigneeRepo.findAll();
	}

	@RequestMapping(value = "/assignees/{id}", method = RequestMethod.GET)
	public Object getAssignee(@PathVariable long id) {
		return assigneeRepo.findById(id);
	}
	
	
	//ÄÄÄ
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Page<Assignee> search(
			@RequestParam(name="search_value", defaultValue="") String search_value,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="4") int size){
		return assigneeRepo.search("%"+search_value+"%", new PageRequest(page, size));
	}

	@RequestMapping(value = "/assignees", method = RequestMethod.POST)
	public Assignee saveAssignee(@RequestBody Assignee a) {
		return assigneeRepo.save(a);
	}
	
	@RequestMapping(value = "/assignees/{id}", method = RequestMethod.DELETE)
	public boolean deleteAssignee(@PathVariable Long id) {
		assigneeRepo.deleteById(id);
		return true;
	}

	@RequestMapping(value = "/assignees/{id}", method = RequestMethod.PUT)
	public Assignee editAssignee(@PathVariable Long id, @RequestBody Assignee a) {
		a.setId(id);
		return assigneeRepo.save(a);
	}
}
