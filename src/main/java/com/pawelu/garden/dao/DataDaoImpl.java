/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawelu.garden.dao;

import com.pawelu.garden.model.Valve;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author epawura
 */
public class DataDaoImpl implements DataDao{

    //@Inject podobno dzialaja tak samo; zdefiniowane w roznych pakietach
    @Autowired
    SessionFactory sessionFactory;
    
    Session session = null;
    Transaction transaction = null;
    
    @Override
    public boolean addEntity(Valve valve) throws Exception {
        		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(valve);
		transaction.commit();
		session.close();

		return false;
    }

    @Override
    public Valve getEntityById(int id) throws Exception {
        		session = sessionFactory.openSession();
		Valve valve = (Valve) session.load(Valve.class,
				new Integer(id));
		transaction = session.getTransaction();
		session.beginTransaction();
		transaction.commit();
		return valve;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Valve> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		List<Valve> employeeList = session.createCriteria(Valve.class)
				.list();
		transaction.commit();
		session.close();
		return employeeList;
	}

        @Override
	public boolean deleteEntity(int id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Valve.class, id);
		transaction = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		transaction.commit();
		return false;
	}

    @Override
    public boolean updateEntity(Valve valve) throws Exception {
                session = sessionFactory.openSession();
		Valve valvee = (Valve) session.load(Valve.class, new Integer((valve.getId())));
                if(valve.getDatee() != null) {
                 valvee.setDatee(valve.getDatee());   
                }
                if(valve.getValve() != null) {
                    valvee.setValve(valve.getValve());
                }
		transaction = session.getTransaction();
		session.beginTransaction();
		session.saveOrUpdate(valvee);
		transaction.commit();
		return false;
    }

    
}
