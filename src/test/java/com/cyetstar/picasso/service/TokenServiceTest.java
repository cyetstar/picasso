package com.cyetstar.picasso.service;

import static org.junit.Assert.*;

import org.cyetstar.picasso.entity.Token;
import org.cyetstar.picasso.service.TokenService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles("test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TokenServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TokenService tokenService;

	@Test
	public void save() {
		Token token = tokenService.saveTokenFormString("约翰福音 1：1");
		assertNotNull(token);

		token = tokenService.saveTokenFormString("约翰福音 1:1");
		assertNotNull(token);
	}

}
