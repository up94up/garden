/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawelu.garden.services;

import com.pawelu.garden.model.Valve;
import com.pawelu.garden.dao.DataDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author epawura
 */
public class DataServicesImpl implements DataServices{

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Valve valve) throws Exception {
		return dataDao.addEntity(valve);
	}

	@Override
	public Valve getEntityById(int id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Valve> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(int id) throws Exception {
		return dataDao.deleteEntity(id);
	}

        @Override
        public boolean updateEntity(Valve valve) throws Exception {
             return dataDao.updateEntity(valve);
        }
    
}
