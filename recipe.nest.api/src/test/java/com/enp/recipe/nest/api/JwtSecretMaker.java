package com.enp.recipe.nest.api;

/*
 * @(#)JwtSecretMaker.java 1.0 12/10/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * Clase controller para gestion de reservas
 *
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

public class JwtSecretMaker {
	
	@Test
	public void generateSecretKey() {
		SecretKey key = Jwts.SIG.HS512.key().build();
		String encodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
		System.out.println("Key ->{{"+encodedKey+"}}<-");
	}

}