package com.crudapp.ops.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crudapp.ops.model.Employeerec;
import com.crudapp.ops.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Value;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public List<Employeerec> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Value("${environment}")
    String retenv;

    @Value("${version}")
    String retversion;


    @GetMapping("/version")
    public String version() {
        String jsonVersion = "{\"environment\":\"+retenv+\",\"version\":\"+retversion+\"}"; 
        ObjectMapper mapper = new ObjectMapper();
	// create a JSON object
	ObjectNode JSONObject = mapper.createObjectNode();
	JSONObject.put("environment", retenv);
	JSONObject.put("version", retversion);
        try {
           String JSONString = mapper.writeValueAsString(JSONObject);
            return JSONString;
        } catch(Exception e) {
      	    return ("Error "+e);
	}
    }

    @PostMapping("/create")
    public ResponseEntity<Employeerec> createEmployee(@RequestBody Employeerec employeerec) {
	try {
		Employeerec _employeerec = employeeRepository 
				.save(new Employeerec(employeerec.getEmployeeID(), employeerec.getEmployeeFirstName(), employeerec.getEmployeeLastName()));
		return new ResponseEntity<>(_employeerec, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employeerec> getTutorialById(@PathVariable("id") long id) {
	Optional<Employeerec> employeeData = employeeRepository.findById(id);
	if (employeeData.isPresent()) {
		return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employeerec> updateEmployee(@PathVariable("id") long id, @RequestBody Employeerec employeerec) {
	Optional<Employeerec> employeeData = employeeRepository.findById(id);
	if (employeeData.isPresent()) {
		Employeerec _employee = employeeData.get();
		_employee.setEmployeeID(employeerec.getEmployeeID());
		_employee.setEmployeeFirstName(employeerec.getEmployeeFirstName());
		_employee.setEmployeeLastName(employeerec.getEmployeeLastName());
		return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
	try {
		employeeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
   }

}

