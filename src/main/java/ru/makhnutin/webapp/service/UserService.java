package ru.makhnutin.webapp.service;

import ru.makhnutin.webapp.model.User;
import java.util.List;

public interface UserService {

	User fineById(Long id);

	void saveUser(User contact);

	List<User> findAllUsers();

	void deleteUserById(Long id);
}
