package com.matheus.crm.controller;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.matheus.crm.entity.UserModel;
import com.matheus.crm.repository.UserRepository;
import com.matheus.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class AuthController {


	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/all")
	public ResponseEntity<List<UserModel>> findAllUsers() {
		List<UserModel> users = userService.findAll();

		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}


	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody UserModel userModel) {

		Optional<UserModel> existingUser = userRepository.findByUsername(userModel.getUsername());
		if (existingUser.isPresent()) {
			return new ResponseEntity<>("Usuário já existe", HttpStatus.BAD_REQUEST);
		}

		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userRepository.save(userModel);
		return ResponseEntity.ok("Usuário criado com sucesso");
	}


	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserModel user) {
		String username = user.getUsername();
		String password = user.getPassword();

		Optional<UserModel> existingUser = userRepository.findByUsername(username);

		if (existingUser.isPresent()) {
			UserModel storedUser = existingUser.get();
			String storedPassword = storedUser.getPassword();


			if (passwordEncoder.matches(password, storedPassword)) {

				String token = generateJwtToken(username);

				Map<String, String> response = new HashMap<>();
				response.put("token", token);
				System.out.println("Acesso liberado: " + token);
				return ResponseEntity.ok("Acesso liberado: " + response);

			}
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nome de usuário ou senha inválidos");
	}



	private String generateJwtToken(String username) {

		Key signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);


		long tokenExpiration = 3600000;


		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
				.signWith(signingKey)
				.compact();

		return token;
	}
}

