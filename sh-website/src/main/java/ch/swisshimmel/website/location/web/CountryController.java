package ch.swisshimmel.website.location.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.swisshimmel.website.location.service.CountryService;
import ch.swisshimmel.website.persist.location.entity.Country;

@Controller
public class CountryController {

    
    @Autowired
    private CountryService service;

    
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public String listProperty(Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("listCountry", this.service.listCountry());
        return "country";
    }
    
    @RequestMapping(value= "/country/add", method = RequestMethod.POST)
    public String addProperty(@ModelAttribute("country") @Valid Country c,BindingResult result, Model model ){

        if (result.hasFieldErrors()) {
            model.addAttribute("listCountry", this.service.listCountry());
                return "country";
           }
    
        if(c.getCountryId() == 0){
            //new person, add it
            this.service.addCountry(c);
        }else{
            //existing person, call update
            this.service.updateCountry(c);
        }
         
        return "redirect:/country";
         
    }
     
    @RequestMapping("/removeCountry/{id}")
    public String removeProperty(@PathVariable("id") int id){
         
        this.service.removeCountry(id);
        return "redirect:/country";
    }
  
    @RequestMapping("/editCountry/{id}")
    public String editProperty(@PathVariable("id") int id, Model model){
        model.addAttribute("country", this.service.getCountryById(id));
        model.addAttribute("listCountry", this.service.listCountry());
        return "country";
    }
   
    
    
}
