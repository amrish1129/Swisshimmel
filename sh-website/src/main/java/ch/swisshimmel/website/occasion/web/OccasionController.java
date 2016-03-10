package ch.swisshimmel.website.occasion.web;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.swisshimmel.website.occasion.persist.entity.Occasion;
import ch.swisshimmel.website.occasion.service.OccasionService;

@Controller
public class OccasionController {
	
	@Autowired
	private OccasionService occasionService;

	 @RequestMapping(value = "/occasion", method = RequestMethod.GET)
	    public String listProperty(Model model) {
	        model.addAttribute("occasion", new Occasion());
	        model.addAttribute("listOccasion", this.occasionService.listOccasion());
	        return "occasion";
	    }
	     
	    //For add and update Property both
	    @RequestMapping(value= "/occasion/add", method = RequestMethod.POST)
	    public String addProperty(@ModelAttribute("occasion") @Valid Occasion o,BindingResult result, Model model ){

	        if (result.hasFieldErrors()) {
	            model.addAttribute("listCountry", this.occasionService.listOccasion());
	                return "occasion";
	           }
	        occasionService.addOccasion(o);
	    
	                                                                                                                              
	         
	        return "redirect:/occasion";
	         
	    }
	     
	   
	   
}
