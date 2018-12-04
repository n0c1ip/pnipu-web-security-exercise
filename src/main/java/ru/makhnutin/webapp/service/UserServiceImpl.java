package ru.makhnutin.webapp.service;

import ru.makhnutin.webapp.model.User;
import ru.makhnutin.webapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User fineById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}


}
