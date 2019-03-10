package com.krios.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
@Autowired
UserRepository userRepo;

public void Adduser(User u)
{
	userRepo.save(u);
}
public List<User> ShowRecords()
{
	List<User> list = new ArrayList<User>();
	 
	 for(User user : userRepo.findAll()) {
		 list.add(user);
	 }
	 return list;

}
public List<User> deleteRecord(int id)
{
	System.out.println("service"+id);
	userRepo.deleteById(id);
	
	return (List<User>) userRepo.findAll();
	
}
public Optional<User> Getsingeldata(User u)
{
	int id=u.getId();
	
	Optional<User> list=userRepo.findById(id);
	return list;

	
}
public Optional<User> logincheck(String uname,String pass)
{
	Optional<User> list=userRepo.findByUnameAndPass(uname, pass);
	
	return list;
	
}
}
