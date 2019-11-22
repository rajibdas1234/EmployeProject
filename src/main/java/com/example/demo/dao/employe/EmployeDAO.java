package com.example.demo.dao.employe;

import java.util.List;

import com.example.demo.domain.employe.EmployeDomain;
import com.example.demo.response.Response;

public interface EmployeDAO {

	public Response create(EmployeDomain employeDoamin)throws Exception;
	
	public List<EmployeDomain>listEmploye()throws Exception;
}
