/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawelu.garden.services;

import com.pawelu.garden.model.Valve;
import java.util.List;

/**
 *
 * @author epawura
 */
public interface DataServices {
	public boolean addEntity(Valve valve) throws Exception;
	public Valve getEntityById(int id) throws Exception;
	public List<Valve> getEntityList() throws Exception;
	public boolean deleteEntity(int id) throws Exception;
        public boolean updateEntity(Valve valve) throws Exception;
    
}
