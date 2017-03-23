package com.dmt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class IfconfigController {
    
    @RequestMapping("/ip")
    public String Ifconfig(HttpServletRequest request) {
    	//is client behind something?
    	String ipAddress = request.getHeader("X-FORWARDED-FOR");
    	if (ipAddress == null) {
    		   ipAddress = request.getRemoteAddr();
    	}
    	
    	return ipAddress;
    }
}