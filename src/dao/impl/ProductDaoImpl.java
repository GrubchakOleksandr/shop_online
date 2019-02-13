package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import dao.ProductDao;
import domain.Product;
import shared.FactoryManager;
import utils.ConnectionUtils;

public class ProductDaoImpl implements ProductDao {
	
	private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);
	private EntityManager em = FactoryManager.getEntityManager();
	
	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		LOGGER.error("sss");
		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			

		} catch (Exception e) {
			LOGGER.error(e);
		}

		return product;
	}

	@Override
	public Product update(Product product) {

		try {
			
		} catch (Exception e) {
			LOGGER.error(e);
		}

		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAll() {
		Query query = null;
		try {
			query=em.createQuery("SELECT e FROM product e");
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return (List<Product>) query.getResultList();
	}

}