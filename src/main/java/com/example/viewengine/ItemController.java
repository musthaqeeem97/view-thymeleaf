package com.example.viewengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

	@GetMapping("/list")
	public String itemList(Model model) {
		
		List<String> items = Arrays.asList("Luffy","Sanji","Zoro");
		
		model.addAttribute("items",items);		
		return "list";
	}
	
	@GetMapping("/table/{name}/{age}")
	public String table(@PathVariable("name") String name ,
			@PathVariable("age") int age,Model model) 
	{
		List<Item> tableList = new ArrayList<>(); 
		tableList.add(new Item("luffy", 19));
		tableList.add(new Item("zoro", 21));
		tableList.add(new Item("sanji", 21));
		tableList.add(new Item(name, age));
		
		model.addAttribute("tableList",tableList);
		
		return "table";
	}
}
