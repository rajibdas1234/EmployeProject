package com.example.demo.dao.employe;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.constants.StatusCode;
import com.example.demo.domain.employe.EmployeDomain;
import com.example.demo.response.Response;
import com.example.demo.utils.CommonUtils;

@Transactional
@Repository
public class EmployeDAOImpl implements EmployeDAO {

	private static final Logger logger=LoggerFactory.getLogger(EmployeDAOImpl.class);
	@Autowired
	EntityManager entityManager;

	@Override
	public Response create(EmployeDomain employeDoamin) throws Exception {
		Response response=CommonUtils.getResponseObject("Employe Data Adding");
		try {
			entityManager.persist(employeDoamin);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setStatus(StatusCode.SUCCESS.getCode());
		}catch(Exception e) {
			logger.info("Exception in creating Data in Employee" + e.getMessage());
			response.setStatusText(StatusCode.ERROR.name());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeDomain> listEmploye() throws Exception {
		try {
			String hql="From EmployeDomain ";
			return (List<EmployeDomain>)entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			logger.info("Exception in Getting all List Data" +e.getMessage());
		}
		return null;
	}
}
