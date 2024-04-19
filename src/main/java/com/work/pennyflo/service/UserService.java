package com.work.pennyflo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.work.pennyflo.entity.User;
import com.work.pennyflo.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
