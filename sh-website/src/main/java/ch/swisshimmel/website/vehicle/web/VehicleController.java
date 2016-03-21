package ch.swisshimmel.website.vehicle.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author amrish
 *
 */
@Controller
public class VehicleController {
    
    @RequestMapping(value="vehicle/register", method=RequestMethod.GET)
    public String registerVehicle() {
        return "vehicle_register";
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String vehicleHome() {
        return "home";
    }
}
