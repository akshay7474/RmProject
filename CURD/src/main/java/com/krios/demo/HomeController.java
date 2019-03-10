package com.krios.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class HomeController {

	@Autowired
	UserService userS;
	
	List<User> list=new ArrayList<>();
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home()
	{
		return "index";
	}
	
	@RequestMapping(value="/Register",method=RequestMethod.GET)
    public String Registerpage()
    {
		return "Register";
    }
	//@CrossOrigin(origins="http://localhost:8080/reg")
	@RequestMapping(value="/reg",method=RequestMethod.POST ,produces="application/json")
	public String AddData(@RequestBody User u)
	{
		System.out.println("register data method");
		System.out.println(u.getUname());
		userS.Adduser(u);
		return "success";
	}
	
	
	@RequestMapping(value="/delet",method=RequestMethod.GET)
	public String DeleteRecord(@RequestParam int id)
	{
		System.out.println("Delete Api-----------------------"+id);
		
	  	userS.deleteRecord(id);
		
		/*System.out.println(list);
		m.addAttribute("data", list );*/
		return "Success";
	}
@RequestMapping(value="/edit",method=RequestMethod.GET)
	public User SingleRecord(@ModelAttribute User u)
	{
	System.out.println(u.getId());
		User list=userS.Getsingeldata(u).get();
		
		System.out.println(list);
		//m.addAttribute("data", list);
		return list;
		
	}
	@RequestMapping(value="/updt",method=RequestMethod.POST)
	public String Updateinfo(@RequestBody User u)
	{
		System.out.println(u.getName());
		userS.Adduser(u);
		List list=userS.ShowRecords();
		System.out.println(list);
		//m.addAttribute("msg", "Data updated Successfully ");
		//m.addAttribute("data", list );
		return "Success";
	}
	
	@RequestMapping("/regist")
	public String AddNewRecord()
	{
		return "Register";
		
	}
	@RequestMapping(value="/logcheck",method=RequestMethod.POST)
	public Optional<User> LoginCheck(@RequestBody User u)
	{
		
		String uname=u.getUname(); 
		String pass=u.getPass();
		Optional<User> list=userS.logincheck(uname, pass);
		if(list.isPresent())
		{
			return list;
		}
	
		return null;
		
	
	}
	
	@RequestMapping(value="/data",method=RequestMethod.GET)
	public @ResponseBody List<User> Alldata()
	{
		List<User> l=userS.ShowRecords();
		return l;	
	}
	
	
	
}
