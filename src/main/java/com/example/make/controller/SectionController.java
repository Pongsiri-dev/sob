package com.example.make.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.make.model.User;
import com.example.make.services.UserService;
import com.google.gson.Gson;

@RestController
@RequestMapping("section")
public class SectionController {
	
	@Autowired
	private UserService userSerive;
	
	private String USER_APT = "https://jsonplaceholder.typicode.com/users";

	@GetMapping("a")
	@ResponseBody
	public static void solutionA(@RequestParam int n) {
		int i, j, k;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter value of n");
//		n = sc.nextInt();
		if (n > 0) {
			System.out.println("----Start  Solution A -----");
			for (i = n; i >= 1; i--) {
				// loop left
				for (j = i; j < n; j++) {
					System.out.print(" O");
				}
				for (j = 1; j <= (2 * i - 1); j++) {
					if (j == 1 || j == (2 * i - 1))
						System.out.print(" X");
					else if (j == 1 || j % 2 != 0)
						System.out.print(" X");
					else
						System.out.print(" O"); // top V
				}
				for (k = i; k < n; k++) {
					System.out.print(" O"); // right v
				}
				System.out.println("");
			}
			for (i = 2; i <= n; i++) {
				for (j = i; j < n; j++) {
					System.out.print(" O");
				}
				for (j = 1; j <= (2 * i - 1); j++) {
					if (j == 1 || j == (2 * i - 1))
						System.out.print(" X");
					else if (j == 1 || j % 2 != 0)
						System.out.print(" X");
					else
						System.out.print(" O");
				}
				for (k = i; k < n; k++) {
					System.out.print(" O"); // right v
				}
				System.out.println("");
			}

			System.out.println("-----End-----");
		}
	}

	@GetMapping("b")
	@ResponseBody
	public static void solutionB(@RequestParam int n) {
		int sh = n / 2;
		if (n > 0) {
			System.out.println("-----Start Solution B -----");
			for (int i = 1; i <= n; i++) {
				if (i <= n / 2) {
					for (int j = 1, s = n - i; j <= n; j++, s--) {
						if (s > 0 && j > i) {
							System.out.print(" ");
						} else {
							System.out.print("X");
						}
					}
					System.out.println();
				} else {
					for (int j = n, s = sh; j > 0; j--, s--) {
						if (s > 0 && j < i) {
							System.out.print(" ");
						} else {
							System.out.print("X");
						}
					}
					sh++;
					System.out.println("");
				}
			}
			System.out.println("-----End-----");
		}
	}

	@GetMapping("c")
	@ResponseBody
	public static void solutionC(@RequestParam int n) {
		if (n > 0) {
			System.out.println("----- Start Solution C -----");
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == 2 && j < n && n > 2) {
						System.out.print("Y");
					} else if (n > 3 && i == 3 && j == n - 1) {
						System.out.print("Y");
					} else if (n > 5 && (i > 3 && i < n - 1) && (j == 2 || j == n - 1)) {
						System.out.print("Y");
					} else if (n > 6 && i == 4 && (j > 2 && j < n - 2)) {
						System.out.print("Y");
					} else if (n > 4 && i == n - 1 && j > 1 && j < n) {
						System.out.print("Y");
					} else {
						System.out.print("X");
					}
				}
				System.out.println();
			}
			System.out.println("-----End-----");
		}
	}

	@GetMapping("/date")
	@ResponseBody
	public static String solutionDate(@RequestParam String dayDate) {
//		String monthp[] = []
		return dayDate.substring(6, 10);
	}

	@GetMapping("/users")
	public ModelAndView getAllUser() {
		List<User> data = userSerive.userList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", data.toString());
		mav.setViewName("users");
		return mav;
	}
	
	@PostMapping("/search")
	public String getUserById(@RequestParam String keyword,@RequestParam String srchBy) {
		List<User> list = userSerive.findUserByCriteria(keyword,srchBy);
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", list.toString());
		mav.setViewName("users");
		return list.toString();
	}
}
