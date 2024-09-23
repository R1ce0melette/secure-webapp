package edu.deakin.sit218.vulnweb.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDAOImpl implements UserDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean areCredentialsCorrect(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> retrieveUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUserByID(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
