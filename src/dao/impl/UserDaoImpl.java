package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import dao.UserDao;
import domain.User;
import shared.FactoryManager;
import utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {

	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	private EntityManager em = FactoryManager.getEntityManager();
	
	@Override
	public User create(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return user;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			em.find(User.class, id);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return user;
	}

	@Override
	public User update(User user) {
		try {
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		try {
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<User> readAll() {
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> from = cq.from(User.class);
			cq.select(from);
			cq.where(cb.equal(from.get("email"), email));
			TypedQuery<User> tq = em.createQuery(cq);
			user = tq.getSingleResult();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return user;
	}
}