package com.johnson.membersDirectory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class MembershipController {
	
	@Autowired
	private MembershipRepo membershipRepo; 
	
	
	
	@GetMapping(value="/")
	public String index(Model model) {
		ArrayList<Membership> membershipList = (ArrayList<Membership>) membershipRepo.findAll();
	     //model.addAttribute("items", todoList);
	     model.addAttribute("newmember", new Membership());
	     model.addAttribute("members", new MembershipView(membershipList));
	     return "membership/index";
	}
	 
	
	@GetMapping(value = "/membership/new")
	public String newMember(Membership membership) {
		return "membership/new";
	}
	
	
	// post new task to database
		@PostMapping("membership/new")
		public String submitTodoTask(Membership membership, Model model) {
			model.addAttribute("id", membership.getId());
			model.addAttribute("firstName", membership.getFirstName());
			model.addAttribute("lastName", membership.getLastName());
			model.addAttribute("email", membership.getEmail());
			model.addAttribute("phone", membership.getPhone());
			model.addAttribute("gender", membership.getGender());
			model.addAttribute("profession", membership.getProfession());
			model.addAttribute("city", membership.getCity());
//			model.addAttribute("birthday", membership.getBirthday());
			
			
			membershipRepo.save(membership);
			model.addAttribute("members", membershipRepo.findAll());
			return "membership/index";
		}
		
		@GetMapping("/membership/edit/{id}")
		public String getEdipPage(@PathVariable Long id, Membership membership, Model model) {
			Membership member = membershipRepo.findById(id).orElseThrow(() -> (new IllegalArgumentException("invalid id " + id)));
			model.addAttribute("members", member);
			return "membership/update";
		}

		// EDIT a specific task on edit page
		@PutMapping("todolist/index/{id}")
		public String updateMember(@PathVariable Long id, Membership membership, Model model) {
			Membership editMember = membershipRepo.findById(id).orElse(null);
			membership.setFirstName(membership.getFirstName());
			membership.setLastName(membership.getLastName());
			membership.setEmail(membership.getEmail());
			membership.setPhone(membership.getPhone());
			membership.setGender(membership.getGender());
			membership.setProfession(membership.getProfession());
			membership.setCity(membership.getCity());
//			membership.setBirthday(membership.getBirthday());
			
			membershipRepo.save(membership);
			model.addAttribute("memberships", membershipRepo.findAll());
			return "membership/idex";
		}
		
}
