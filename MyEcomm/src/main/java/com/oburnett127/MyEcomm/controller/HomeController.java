package com.oburnett127.MyEcomm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oburnett127.MyEcomm.util.ServiceError;

@Controller
public class HomeController {
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//    public @ResponseBody ModelAndView getMessage() {
//        var mav = new ModelAndView();
//        mav.setViewName("index");
//        return mav;
////		return "cookies";
//    }
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public @ResponseBody ModelAndView showIndex() {
//      var mav = new ModelAndView();
//      mav.setViewName("index");
//      return mav;
////		return "cookies";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		//model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";

	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}