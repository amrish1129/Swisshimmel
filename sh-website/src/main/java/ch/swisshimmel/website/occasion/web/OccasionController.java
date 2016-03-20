package ch.swisshimmel.website.occasion.web;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.swisshimmel.website.common.constants.OccasionConstants;
import ch.swisshimmel.website.common.ds.OccasionDS;
import ch.swisshimmel.website.occasion.persist.entity.Occasion;
import ch.swisshimmel.website.occasion.persist.entity.OccasionTime;
import ch.swisshimmel.website.occasion.service.OccasionService;


@Controller
public class OccasionController {
	
	@Autowired
	private OccasionService occasionService;


	 @RequestMapping(value = "/occasion", method = RequestMethod.GET)
	    public String listProperty(Model model) {
	        model.addAttribute("occasion", new Occasion());
	        model.addAttribute("listOccasion", this.occasionService.listOccasion());
	        model.addAttribute(OccasionConstants.OCCASION_VALUE_DS,getOccDisSettings(OccasionConstants.ADD_OCCASION));
	        return "occasion";
	    }
	     
	    //For add and update Property both
	    @RequestMapping(value= "/occasion/add", method = RequestMethod.POST)
	    public String addProperty(@ModelAttribute("occasion") @Valid Occasion o,BindingResult result, Model model ){

	        if (result.hasFieldErrors()) {
	            model.addAttribute("listCountry", this.occasionService.listOccasion());
	            model.addAttribute(OccasionConstants.OCCASION_VALUE_DS,getOccDisSettings(OccasionConstants.ADD_OCCASION));

	                return "occasion";
	           }
	        occasionService.addOccasion(o);
	         
	        return "redirect:/occasion";
	         
	    }
	     	    
	    //For add and update Property both
        @RequestMapping("/addEventTime/{id}")
        public String addEventTime(@PathVariable("id") int id, 
                
            Model model,@RequestParam (value = "action", required = false) String action ,
            
            @ModelAttribute("occasion") @Valid Occasion oIn, BindingResult result) {
            String returnPage = "addOccasionEvent";
            Occasion o = null;
            
            if(result.hasErrors()) {
                System.out.println("Errors found");
            }
            
        // Check If form has any error
         if (null == action || action.equals("")) {
            o = occasionService.getOccasionById(id);
        } else if (null != action && action.equals("saveEvent") && !result.hasErrors()) {
            id = oIn.getOccasion_id();
            occasionService.updateOccasion(oIn);
            o = occasionService.getOccasionById(id);
        } else if (null != action && action.equals("addRow")) {
            List<OccasionTime> list = oIn.getOccasionTimes();
            list.add(new OccasionTime());
            o = oIn;
        }
        
        // o.setEnabled(true);
        model.addAttribute("occasion", o);
        model.addAttribute(OccasionConstants.OCCASION_VALUE_DS,
                getOccDisSettings(OccasionConstants.ADD_EVENT_TIME));
        return "addOccasionEvent";
             
        }
        
        

        private OccasionDS getOccDisSettings(String displayKey) {
            OccasionDS ds = new OccasionDS();
           if(OccasionConstants.ADD_EVENT_TIME.equals(displayKey)) {
               ds.setOccasionValuesEnabled(false);
               ds.setViewButtonEnabled(false);
           } else if (OccasionConstants.ADD_OCCASION.equals(displayKey)){
               ds.setOccasionValuesEnabled(true);
               ds.setViewButtonEnabled(true);
           }
            return ds;
        }
}
