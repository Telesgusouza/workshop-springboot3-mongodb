package com.gustavo.workshop.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.bson.BsonUndefined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.workshop.Repository.UserRepository;
import com.gustavo.workshop.domain.User;
import com.gustavo.workshop.dto.UserDTO;
import com.gustavo.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		try {
			Optional<User> newUser = repo.findById(obj.getId());
			User user = newUser.get();
			updateData(user, obj);
			return repo.save(user);
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Object not found.");
		}
	}

	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
	}
}
