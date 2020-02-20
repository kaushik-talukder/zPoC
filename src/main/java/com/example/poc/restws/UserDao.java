package com.example.poc.restws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static List<User> users = new ArrayList<>();
	private static int userId = 3;

	static {
		users.add(new User(1, "Kaushik"));
		users.add(new User(2, "Mike"));
		users.add(new User(3, "Chris"));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findOne(Integer id) {
		User user = null;
		for (User u : users) {
			if (u.getId() == id) {
				user = u;
			}
		}
		return user;
	}

	public User save(User user) {
		user.setId(++userId);
		users.add(user);
		return user;
	}
}
