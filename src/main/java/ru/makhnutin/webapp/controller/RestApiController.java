package ru.makhnutin.webapp.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.makhnutin.webapp.model.User;
import ru.makhnutin.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers(@PathVariable("id") long id) {
		User user = userService.fineById(id);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		User currentContact = userService.fineById(id);
		if (currentContact == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		currentContact.setUserName(user.getUserName());
		currentContact.setEmail(user.getEmail());
		userService.saveUser(currentContact);
		return new ResponseEntity<>(currentContact, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		User contact = userService.fineById(id);
		if (contact == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}