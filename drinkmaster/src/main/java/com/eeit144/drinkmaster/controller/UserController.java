package com.eeit144.drinkmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eeit144.drinkmaster.bean.UserBean;
import com.eeit144.drinkmaster.dto.UserBeanDTO;
import com.eeit144.drinkmaster.model.UserService;
import com.eeit144.drinkmaster.service.UserServiceImp;

@Controller
@Transactional
@RequestMapping("/backend")
public class UserController {

	@Autowired
	private UserServiceImp userService;
	
	@GetMapping("user/insert")
	public String insertUser(Model m) {
		UserBean userBean = new UserBean();
		m.addAttribute("user", userBean);
		
		return "backuseradd";
	}
	
	@PostMapping("user/insertGo")
	public String insertUserGo(@ModelAttribute("user") UserBean userBean, Model m) {
		userService.insertUser(userBean);
		
		return "redirect:/backend/user/all";
	}
	
	@GetMapping("user/all")
	public ModelAndView findView(ModelAndView mav, @RequestParam(name="u", defaultValue = "1") Integer pageNumber) {
		Page<UserBean> page = userService.findAll(pageNumber);
		
		mav.getModel().put("page", page);
		mav.setViewName("backuser");
		return mav;
	}
	
	@GetMapping("user/select")
	public ModelAndView selectLike(ModelAndView mav, @RequestParam(name="u", defaultValue = "1") Integer pageNumber,
			@RequestParam("select") String select) {
		System.out.println(select);
		
		Page<UserBean> page = userService.select(pageNumber, "%" + select + "%");
		mav.getModel().put("page", page);
		
		mav.setViewName("backuser");
		return mav;
	}
	
	@GetMapping("deleteuser")
	public String deleteById(@RequestParam("id") Integer id) {
		userService.deleteById(id);
		return "redirect:/backend/user/all";
	}
	
	@GetMapping("user/update")
	public String updateById(@RequestParam("id") Integer id, Model m) {
		UserBean userBean = userService.findById(id);
		m.addAttribute("user", userBean);
		return "backuserupdate";
	}
	
	@PostMapping("user/updateGo")
	public String updateGo(@ModelAttribute("user") UserBean userBean, Model m) {
		userService.insertUser(userBean);
		
		return "redirect:/backend/user/all";
	}
}
