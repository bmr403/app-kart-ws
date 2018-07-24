package com.kart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kart.domain.Demo;
import com.kart.repository.CntAbstractDao;

@Repository("AppProductDAO")
public class ProductDAO extends CntAbstractDao {
	public ProductDAO() {
		super();
	}
	
	/*
	 * Demo Methods
	 */

	private DetachedCriteria createDemoCriteria(Demo demo, String searchType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Demo.class);
		if (searchType.equalsIgnoreCase("exact")) {
			if (demo.getDemoName() != null) {
				criteria.add(Restrictions.eq("demoName",
						"" + demo.getDemoName().toUpperCase() + ""));
			}
		} else {
			if (demo.getDemoName() != null) {
				criteria.add(Restrictions.like("demoName", "" + demo.getDemoName() + "%")
						.ignoreCase());
			}
			if (demo.getDemoDescription() != null) {
				criteria.add(Restrictions
						.like("demoDescription", "%" + demo.getDemoDescription() + "%")
						.ignoreCase());
			}
			
			
		}
		
		return criteria;

	}
	
	@SuppressWarnings("unchecked")
	public List<Demo> getAllDemosBySearchParam(Demo demo) {
		DetachedCriteria criteria = createDemoCriteria(demo,"");
		criteria.addOrder(Order.desc("demoId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return super.getAllObjectList(Demo.class, criteria);
	}
	

	public int getDemoMasterListFilterCount(Demo demo) {
		DetachedCriteria criteria = createDemoCriteria(demo, "");
		return super.getObjectListCount(Demo.class, criteria);
	}

	public List getDemoMasterList(int start, int limit, Demo demo) {
		DetachedCriteria criteria = createDemoCriteria(demo, "");
		return super.getObjectListByRange(Demo.class, criteria, start, limit);
	}

	public void saveDemoMaster(Demo demo) {
		super.saveOrUpdate(demo);
	}

	public void removeDemoMaster(Demo demo) {
		super.delete(demo);
	}

	public Demo getDemoMaster(Integer demoId) {
		return (Demo) super.find(Demo.class, demoId);
	}

	public Demo getDemoMasterByCode(Demo demo) {
		DetachedCriteria criteria = createDemoCriteria(demo, "exact");
		return (Demo) super.getUniqueObject(Demo.class, criteria);
	}

	/*
	 * End of Demo Methods
	 */
	
}
