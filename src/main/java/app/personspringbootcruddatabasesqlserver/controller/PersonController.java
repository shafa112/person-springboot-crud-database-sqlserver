package app.personspringbootcruddatabasesqlserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.personspringbootcruddatabasesqlserver.model.Person;
import app.personspringbootcruddatabasesqlserver.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/id/{id}")
	public Person getPerson(@PathVariable int id) {
		return service.getPerson(id);
	}
	
	@GetMapping("/all")
	public List<Person> getAll() {
		return service.getAllPerson();
	}
	
	@PostMapping("/insert")
	public int insert(@RequestBody Person person) {
		return service.insert(person);
	}
	
	@PutMapping("/update")
	public int update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@DeleteMapping("/delete")
	public int delete(@RequestBody Person person) {
		// TODO Auto-generated method stub
		return service.delete(person);
	}
}
