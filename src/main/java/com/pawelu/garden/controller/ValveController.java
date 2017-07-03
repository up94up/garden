/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawelu.garden.controller;


import org.apache.log4j.Logger;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pawelu.garden.model.Status;
import com.pawelu.garden.model.Valve;
import com.pawelu.garden.services.DataServices;
//import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author epawura
 */
@Controller
public class ValveController {
    
    @Autowired
    DataServices dataServices;
    
    static final Logger logger = Logger.getLogger(ValveController.class);
    
    
    	@RequestMapping(value = "/hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("<h1>Hello!</h1>", HttpStatus.OK);
	}
        
 @RequestMapping(value = "/test")
 public String home() {
  return "view";
 }

        
    	//params="parametr==wartosc"
        @RequestMapping(value = "/valve", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addValve(@RequestBody Valve valve) {
		try {
			dataServices.addEntity(valve);
			return new Status(1, "Valve setting added succesfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}
        
        @RequestMapping(value = "valve", method = RequestMethod.PUT/*, consumes = MediaType.APPLICATION_JSON_VALUE*/)
	public @ResponseBody
	Status updateValveSetting(@RequestBody Valve valve) throws Exception {

		//try {
			dataServices.updateEntity(valve);
			return new Status(1, "Valve setting updated.");
//		} catch (Exception e) {
//			return new Status(0, e.toString());
//		}

	}
        
        @RequestMapping(value = "/valve/{id}", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody
	Valve getValveById(@PathVariable("id") int id) {
		Valve valve = null;
		try {
			valve = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return valve;
                //return toJSON(valve);
	}
        
//            @RequestMapping("/foo/{id}")
//    ResponseEntity<Foo> getById(@PathVariable("id") String id){
//      return new ResponseEntity<Foo>()repository.getById(id));
//    }

	@RequestMapping(value = "/valve", method = RequestMethod.GET)
	public @ResponseBody
	List<Valve> getAllValves() {

		List<Valve> valveList = null;
		try {
			valveList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return valveList;
	}

	@RequestMapping(value = "valve/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteValveSetting(@PathVariable("id") int id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Valve setting deleted.");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

}
