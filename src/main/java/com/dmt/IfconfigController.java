package com.dmt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IfconfigController {
    
    @RequestMapping("/")
    public String Ifconfig(HttpServletRequest request) {
    	//is client behind something?
    	String ipAddress = request.getHeader("X-FORWARDED-FOR");
    	
    	if (ipAddress == null) {
    		   ipAddress = request.getRemoteAddr();
    	}
    	
    	return ipAddress;
    }
    
    @RequestMapping("/details")
    public String IfconfigDetail(HttpServletRequest request) {
    	String response = "";
    	
    	//String userAgent = request.getHeader("User-Agent");
    	
    	Enumeration<String> headerNames = request.getHeaderNames();
    	if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
            	 	String header = headerNames.nextElement();
                    response = response + " " + header +  ": " + request.getHeader(header);
            }
    	}
    	
    	return response;
    }
    
}