package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class itemDao {
	
	public List<items> getAllitems(){
		
		List<items> userList = null;
	      try {
	         File file = new File("Data.sql");
	         if (!file.exists()) {
	            items item = new items(001,"Parle Biscuits","snacks",125.89);
	            userList = new ArrayList<items>();
	            userList.add(item);
	            //saveUserList(userList);		
	         }
	         else{
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            userList = (List<items>) ois.readObject();
	            ois.close();
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }		
		return userList;
	
	}

}
