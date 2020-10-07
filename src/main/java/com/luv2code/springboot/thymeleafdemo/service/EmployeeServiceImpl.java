package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
@Service 
public class EmployeeServiceImpl implements EmployeeService {

// what is the need of the service ? 
	// all it does is delegates the calls to the DAO 
	
	private EmployeeRepository employeeRepository;
	
	@Autowired    // writing bean id ; 
	public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
		employeeRepository  = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// how to use java optional ? 
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null; 
		if( result.isPresent()) {
			theEmployee = result.get(); 
		}
		else
		{
			// we didn't find the employee 
			throw new RuntimeException("Did not find employee id" + theId);
		}
		return theEmployee; 
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
