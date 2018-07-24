package com.kart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kart.dao.ProductDAO;
import com.kart.domain.Demo;

@Service("AppProductService")
@Transactional
public class ProductService {

	@Autowired
	public ProductDAO productDAO;
	
	/*
	 * Gems Demo Methods
	 */
	
	public List<Demo> getAllCountriesBySearchParam(String demoName,String demoDescription) {
		Demo demo = new Demo();
		if(demoName!=null) {
			demo.setDemoName(demoName);
		}
		if(demoDescription!=null){
			demo.setDemoDescription(demoDescription);
		}
		return productDAO.getAllDemosBySearchParam(demo);
	}
	
	
	public int getDemoListFilterCount(Demo demo) {
		return productDAO.getDemoMasterListFilterCount(demo);
	}

	public List<Demo> getGemsCountryList(int start, int limit, Demo countryMaster) {
		return productDAO.getDemoMasterList(start, limit, countryMaster);
	}

	
	public Demo getDemoObjById(Integer Id) {
		return productDAO.getDemoMaster(Id);
	}
	
	public Demo getDemoByCode(String demoName,String demoDescription) {
		Demo demo = new Demo();
		if(demoName!=null) {
			demo.setDemoName(demoName);
		}
		if(demoDescription!=null){
			demo.setDemoDescription(demoDescription);
		}
		return productDAO.getDemoMasterByCode(demo);
	}
		
	
	public Demo saveDemo(Demo demo) {
		try {
			productDAO.saveDemoMaster(demo);
		} catch (Exception ex) {

		}
		return demo;

	}

	public void removeGemsCountry(Demo countryMaster) {
		productDAO.removeDemoMaster(countryMaster);
	}
	
	/*
	 * End of Demo Methods
	 */
	
}
