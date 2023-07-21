package com.org.jsp.Register.Login.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.jsp.Register.Login.Dto.EmployeeDTO;
import com.org.jsp.Register.Login.Dto.LoginDTO;
import com.org.jsp.Register.Login.Entity.Employee;
import com.org.jsp.Register.Login.Repository.EmployeeRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.jsp.Register.Login.Service.EmployeeService;
import com.org.jsp.Register.Login.responce.LoginResponce;
@Service
public class EmployeeImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public String addEmployee(EmployeeDTO employeeDTO) {

		Employee employee=new Employee(
			
			employeeDTO.getEmployeeid(),
			employeeDTO.getEmployeename(),
			employeeDTO.getEmail(),
			this.passwordEncoder.encode(employeeDTO.getPassword())
				);
		employeeRepository.save(employee);
		
		
		return employee.getEmployeename();
		
	}

    EmployeeDTO employeeDTO;


	@Override
	public LoginResponce LoginEmployee(LoginDTO loginDTO) {
		 String msg = "";
	        Employee employee1 = employeeRepository.findByEmail(loginDTO.getEmail());
	        if (employee1 != null) {
	            String password = loginDTO.getPassword();
	            String encodedPassword = employee1.getPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
	                if (employee.isPresent()) {
	                    return new LoginResponce("Login Success", true);
	                } else {
	                    return new LoginResponce("Login Failed", false);
	                }
	            } else {
	                return new LoginResponce("password Not Match", false);
	            }
	        }else {
	            return new LoginResponce("Email not exits", false);
	        }
	    }
	

}
