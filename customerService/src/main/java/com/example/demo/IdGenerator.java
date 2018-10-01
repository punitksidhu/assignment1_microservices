package com.example.demo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class IdGenerator  implements IdentifierGenerator {

	@Autowired
	private Configuration configuration;
	//String prefix = "DEV";

	public Serializable generate(SharedSessionContractImplementor  session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		
		String prefix=configuration.getEnv();
		 Connection connection = session.connection();

		    try {
		        Statement statement=connection.createStatement();

		        ResultSet rs=statement.executeQuery("select count(CUSTOMER_ID) as Id from customers");

		        if(rs.next())
		        {
		            int id=rs.getInt(1)+101;
		            String generatedId = prefix + new Integer(id).toString();
		            return generatedId;
		        }
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }

		    return null;
	}
	

}
