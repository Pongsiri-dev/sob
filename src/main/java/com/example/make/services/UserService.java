package com.example.make.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.make.model.User;

@Service
public class UserService {
	private String USER_APT = "https://jsonplaceholder.typicode.com/users";
	
	public List<User> userList() {
		RestTemplateBuilder r = new RestTemplateBuilder();
		RestTemplate rt = r.build();
		User[] a = rt.getForObject(USER_APT, User[].class);
		List<User> list = new ArrayList<User>(Arrays.asList(a));
		return list;
	}
	
	public List<User> findUserByCriteria(String keyword,String searchBy){
		RestTemplateBuilder r = new RestTemplateBuilder();
		RestTemplate rt = r.build();
		String url = USER_APT;
		
		if(!"all".equals(searchBy)) {
			System.out.println("searchBy : "+searchBy);
			System.out.println("keyword : "+keyword);
			url = USER_APT+"?"+searchBy+"="+keyword;
		}
		User[] a = rt.getForObject(url, User[].class);
		List<User> list = new ArrayList<User>(Arrays.asList(a));
		return list;
	}

	
}
