package com.matheus.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.crm.entity.User;
import com.matheus.crm.repository.UserRepository;
import com.matheus.crm.security.TokenUtil;
import com.matheus.crm.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	@RequestMapping(
			value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> getUsers() {
		List<User> userList = userRepository.findAll();

		System.out.println("ENTROU CONTROLLER GETUSERS");
		return ResponseEntity.ok(userList);

	}


	@RequestMapping(
			value = "/user/create", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createUser(@RequestBody User user) {
		// Verifica se o usuário já existe
		if (userRepository.findByUsername(user.getUsername()) != null) {
			return new ResponseEntity<>("Usuário já existe", HttpStatus.BAD_REQUEST);
		}

		// Criptografa a senha antes de salvar no banco de dados
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok("Usuário criado com sucesso");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		// Procura o usuário no banco de dados
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser == null) {
			return new ResponseEntity<>("Usuário não encontrado", HttpStatus.NOT_FOUND);
		}

		// Verifica a senha
		if (!bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
			return new ResponseEntity<>("Senha incorreta", HttpStatus.UNAUTHORIZED);
		}

		// Cria o token JWT
		String token = TokenUtil.generateToken(existingUser.getUsername(), existingUser.getRole());

		return ResponseEntity.ok(token);
	}

//	private String generateJwtToken(String username, String role) {
//		// Gera uma chave segura para o algoritmo HS256
//		byte[] signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();
//
//		// Define a duração do token em milissegundos (1 hora neste exemplo)
//		long tokenExpiration = 3600000;
//
//		// Gera o token JWT
//		String token = Jwts.builder()
//				.setSubject(username)
//				.claim("role", role)
//				.setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
//				.signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS256)
//				.compact();
//
//		return token;
//	}

//	@RequestMapping(
//			value = "/user/create", consumes = "application/json", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
//		userDTO = userService.execute(userDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(userDTO.getId()).toUri();
//		return ResponseEntity.created(uri).body(userDTO);
//	}

//	@RequestMapping(
//			value = "/user/role", consumes = "application/json", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<UserRoleDTO> createRole(@RequestBody UserRoleDTO userRoleDTO){
//		userRoleDTO = userRoleService.execute(userRoleDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(userRoleDTO.getId()).toUri();
//		return ResponseEntity.created(uri).body(userRoleDTO);
//	}


//	@RequestMapping(
//			value = "/user/role", consumes = "application/json", method = RequestMethod.POST)
//	@ResponseBody
//	public User role(@RequestBody UserRoleDTO userRoleDTO) {
//		return userRoleService.execute(userRoleDTO);
//	}

//	@PreAuthorize("hasRole('ADMIN')")


//	@RequestMapping(
//			value = "/getusers", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<List<UserDTO>> getUsers(){
//		List<UserDTO> users = userService.findAllUsers();
//		if (users.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.ok().body(users);
//	}

}
