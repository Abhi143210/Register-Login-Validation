package com.org.jsp.Register.Login.EmpController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.jsp.Register.Login.Dto.EmployeeDTO;
import com.org.jsp.Register.Login.Dto.LoginDTO;
import com.org.jsp.Register.Login.Service.EmployeeService;
import com.org.jsp.Register.Login.responce.LoginResponce;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping(path="/save")
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) 
	{
		String id=employeeService.addEmployee(employeeDTO);
		return id;
	}
	@PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponce loginResponce = employeeService.LoginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponce);
    }
}
