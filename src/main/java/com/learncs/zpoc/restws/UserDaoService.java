package com.learncs.zpoc.restws;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
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
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User save(User user) {
		user.setId(++userId);
		users.add(user);
		return user;
	}

	public User deleteById(Integer id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
