package app.personspringbootcruddatabasesqlserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.personspringbootcruddatabasesqlserver.model.Person;
import app.personspringbootcruddatabasesqlserver.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;

	public Person getPerson(int id) {
		return repository.find(id);
	}
	
	public List<Person> getAllPerson() {
		return repository.findAll();
	}

	public int insert(Person person) {
		return repository.insert(person);
	}

	public int update(Person person) {
		return repository.update(person);
	}
	
	public int delete(Person person) {
		return repository.delete(person);
	}
}
