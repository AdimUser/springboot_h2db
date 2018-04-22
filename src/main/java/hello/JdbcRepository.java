package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
	
	 @Autowired
	    ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans.xml");
	    DataSource dataSource = (DataSource) appContext.getBean("dataSource");
	    JdbcTemplate template = new JdbcTemplate(dataSource);
	    
	   
	 
	    	 
	 public String findById(long id) {
		 return (template.queryForObject("select Name from user where id=?", new Object[]{id}, new BeanPropertyRowMapper < Greeting > (Greeting.class))).getName() ;
		
		}
	 

	 public int deleteById(long id) {
		 return template.update("delete from user where id=?", new Object[] {id});

	 }
	 
	 

	 public int insert(Greeting user) {
     return template.update("insert into user (id, name) " + "values(?,  ?)",new Object[] {user.getId(), user.getName() });
     }
	 
	 

	 public int update(Greeting user) {
		 return template.update("update user " + " set name = ?" + " where id = ?",new Object[] {user.getName(), user.getId()
        });
	 }
}



class UserRowMapper implements RowMapper < Greeting > {	
	 @Autowired
	    ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans.xml");
	    DataSource dataSource = (DataSource) appContext.getBean("dataSource");
	    JdbcTemplate template = new JdbcTemplate(dataSource);
	    
    @Override
    public Greeting mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Greeting user = new Greeting();
    	user.setId(rs.getInt("id"));
    	user.setName(rs.getString("Name"));
        return user;
    }
    
    public List < Greeting > findAll() {
    	return template.query("select * from user", new UserRowMapper());
    }


}
		

















