package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Booking;
import com.bms.entity.User;

@Component
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;
	
	//TESTED IN SPRING BOOT
	@Transactional
	public User addOrUpdateUser(User user) {
		return em.merge(user);
	}

	//TESTED IN SPRING BOOT
	public User findUserByUserId(int userId) {
		return em.find(User.class, userId);
	}

	public User findUserByEmailId(String email) {
		String jpql = "select u from User u where u.email=:email";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
	
	//TESTED IN SPRING BOOT
	public List<User> viewAllUsers() {
		String jpql = "select u from User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query.getResultList();
	}

	//?
	@Transactional
	public User addOrUpdateAdmin(User user) {
		return em.merge(user);
	}

	public List<Booking> viewAllBookingsByUserId(int userId) {
		return null;
	}
	
	//TESTED IN SPRING BOOT
	public boolean login(String email, String password) {
		String jpql = "Select u from User u where u.email=:eid and u.password=:pwd";
		TypedQuery<User> qry = em.createQuery(jpql, User.class);
		qry.setParameter("eid", email);
		qry.setParameter("pwd", password);
		User user = qry.getSingleResult();
		return user!=null?true:false;
	}

}
