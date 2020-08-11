package app.personspringbootcruddatabasesqlserver.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.personspringbootcruddatabasesqlserver.model.Person;

@Repository
public class PersonRepository {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	public Person find(int id) {
		String sql = "select * from person where id=?";
		return jdbctemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int insert(Person p) {
		String query = "insert into person values('" + p.getId() + "','" + p.getName() + "','"
				+ p.getAge() + "')";
		System.out.println(query);
		return jdbctemplate.update(query);
	}
	
	public int update(Person p) {
		String query="update person set name='"+p.getName()+"',age='"+p.getAge()+"' where id='"+p.getId()+"' ";  
	    System.out.println(query);
	    return jdbctemplate.update(query); 
	}
	
	public int delete(Person p){  
	    String query="delete from person where id='"+p.getId()+"' ";  
	    System.out.println(query);
	    return jdbctemplate.update(query);  
	}  
	
	public List<Person> findAll() {
		return jdbctemplate.query("select * from person",new MyRowMapper());
	}
	
	class MyRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rownumber) throws SQLException {
			Person p = new Person();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setAge(rs.getInt(3));
			return p;
		}
		
	}

	

	
	
	
}
