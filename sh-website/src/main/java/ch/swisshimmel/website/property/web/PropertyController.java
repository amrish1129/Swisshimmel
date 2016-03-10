package ch.swisshimmel.website.property.web;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.swisshimmel.website.property.persist.entity.Property;
import ch.swisshimmel.website.property.service.PropertyService;

@Controller
public class PropertyController {
	
	@Autowired
	private PropertyService propService;

	 @RequestMapping(value = "/property", method = RequestMethod.GET)
	    public String listProperty(Model model) {
	        model.addAttribute("property", new Property());
	        model.addAttribute("listProperty", this.propService.listProperty());
	        return "property";
	    }
	     
	    //For add and update Property both
	    @RequestMapping(value= "/property/add", method = RequestMethod.POST)
	    public String addProperty(@ModelAttribute("property") @Valid Property p,BindingResult result, Model model ){

	        if (result.hasFieldErrors()) {
	            model.addAttribute("listProperty", this.propService.listProperty());
	                return "property";
	           }
	    
	        if(p.getId() == 0){
	            //new person, add it
	            this.propService.addProperty(p);
	        }else{
	            //existing person, call update
	            this.propService.updateProperty(p);
	        }
	         
	        return "redirect:/property";
	         
	    }
	     
	    @RequestMapping("/removeProp/{id}")
	    public String removeProperty(@PathVariable("id") int id){
	         
	        this.propService.removeProperty(id);
	        return "redirect:/property";
	    }
	  
	    @RequestMapping("/editProp/{id}")
	    public String editProperty(@PathVariable("id") int id, Model model){
	        model.addAttribute("property", this.propService.getPropertyById(id));
	        model.addAttribute("listProperty", this.propService.listProperty());
	        return "property";
	    }
	   
}
