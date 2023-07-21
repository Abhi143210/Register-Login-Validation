package com.org.jsp.Register.Login.Service;

import com.org.jsp.Register.Login.Dto.EmployeeDTO;
import com.org.jsp.Register.Login.Dto.LoginDTO;
import com.org.jsp.Register.Login.responce.LoginResponce;

public interface EmployeeService {

	String addEmployee(EmployeeDTO employeeDTO);
	
	LoginResponce LoginEmployee(LoginDTO loginDTO);

}
