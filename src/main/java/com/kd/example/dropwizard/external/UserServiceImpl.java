package com.kd.example.dropwizard.external;

import java.util.ArrayList;
import java.util.List;

import com.kd.example.dropwizard.models.KUser;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		KUser kUser = new KUser();
		kUser.setId(1L);
		kUser.setUsername("test_user_name");
		kUser.setName("test_name");
		kUser.setLocation("test_loaction");
		users.add(kUser);
	}

	private List<KUser> users = new ArrayList<KUser>();

	@Override
	public KUser getUserById(long id) {
		return findUser(id);
	}

	private KUser findUser(long id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

	@Override
	public void createUser(KUser kUser) {
		users.add(kUser);
	}

	@Override
	public KUser getUserByUsername(String username) {
		return users.stream().filter(user -> username.equals(user.getUsername())).findFirst().orElse(null);
	}
}
