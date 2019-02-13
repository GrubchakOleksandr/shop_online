package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import dao.BucketDao;
import domain.Bucket;
import shared.FactoryManager;
import utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {
	
	private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);
	
	private EntityManager em = FactoryManager.getEntityManager();
	

	@Override
	public Bucket create(Bucket bucket) {

		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			bucket = em.find(Bucket.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			Bucket bucket =read(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Bucket> readAll() {
		
		Query query =null;
		try {
			em.getTransaction().begin();
			query=em.createQuery("SELECT a FROM bucket a");
			em.getTransaction().commit();
			
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return query.getResultList();
	}
}
