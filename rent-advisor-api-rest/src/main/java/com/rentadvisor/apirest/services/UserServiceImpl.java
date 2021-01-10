package com.rentadvisor.apirest.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentadvisor.apirest.dao.UserRepository;
import com.rentadvisor.apirest.entities.UserEntity;
import com.rentadvisor.apirest.pojos.ResponsePojo;
import com.rentadvisor.apirest.pojos.UserPojo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ResponsePojo register(UserPojo userpojo) {
		userpojo.setPassword(passwordEncoder.encode(userpojo.getPassword()));

		UserEntity userEntity = new UserEntity();

		ResponsePojo responsePojo = new ResponsePojo();

		Date currentDate = new Date();

		userEntity.setName(userpojo.getName());
		userEntity.setSurname(userpojo.getSurname());
		userEntity.setEmail(userpojo.getEmail());
		// userEntity.setPassword(bCryptPasswordEncoder.encode(userpojo.getPassword()));
		userEntity.setPassword(userpojo.getPassword());
		userEntity.setRegistrationDate(currentDate);

		try {
			userRepository.save(userEntity);
			responsePojo.setSuccess(true);
			responsePojo.setMessage("Usuario creado correctamente");
		} catch (DataAccessException dataAccessException) {
			responsePojo.setSuccess(false);
			responsePojo.setMessage(dataAccessException.getLocalizedMessage());
		}

		return responsePojo;
	}

	@Override
	public ResponsePojo getJWTToken(UserPojo userPojo) {

		ResponsePojo responsePojo = new ResponsePojo();

		UserEntity userEntity = this.userRepository.findByEmail(userPojo.getEmail());

		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		if (passwordEncoder.matches(userPojo.getPassword(), userEntity.getPassword())) {
			String token = Jwts.builder().setId("softtekJWT").setSubject(userEntity.getName())
					.claim("authorities",
							grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

			String bearerToken = "Bearer " + token;

			responsePojo.setBearerToken(bearerToken);
			responsePojo.setSuccess(true);
			responsePojo.setMessage("Login correcto");
			return responsePojo;
		} else {
			return responsePojo;
		}

	}

}
