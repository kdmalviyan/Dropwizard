package com.kd.example.dropwizard.external;

import com.kd.example.dropwizard.models.KUser;

public interface UserService {

	KUser getUserById(long id);

	void createUser(KUser kUser);

	KUser getUserByUsername(String username);
}
