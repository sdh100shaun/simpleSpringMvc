package com.shaunhare.samplemvc;

import java.util.List;

import mailjimp.dom.list.MailingList;
import mailjimp.service.MailJimpException;
import mailjimp.service.impl.MailJimpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	 @Autowired
	 MailJimpService mailChimpService; 
	 
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelandview = new ModelAndView("home");
		SimpleString simpleString = new SimpleString();
		simpleString.setSimpleString("test");
		modelandview.addObject("simpleString", simpleString);
		List<MailingList> mailingLists;
		try {
			mailingLists = mailChimpService.getLists();
			modelandview.getModel().put("lists", mailingLists);
			logger.info(mailingLists.toArray().toString());
		} catch (MailJimpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		logger.info("Welcome home!");
		logger.info(simpleString.getSimpleString());
		return modelandview;
	}
	
}

