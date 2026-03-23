package com.maxwilliam.MedSystem.security;
import com.auth0.jwt.JWT;

import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.exceptions.JWTCreationException;

import com.auth0.jwt.exceptions.JWTVerificationException;

import com.maxwilliam.MedSystem.model.Funcionario; // Ajuste o import do seu Funcionario

import org.springframework.stereotype.Service;



import java.time.Instant;

import java.time.LocalDateTime;

import java.time.ZoneOffset;



@Service

public class TokenService {
    private String secret = "SenhazinhadaSilvaRobertoCarlosPeleBorges";
    public String gerarToken(Funcionario funcionario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("MedSystem API") // Quem está emitindo o crachá
                    .withSubject(funcionario.getCPF()) // O dono do crachá (usamos o CPF)
                    .withExpiresAt(gerarDataExpiracao()) // A validade do crachá
                    .sign(algorithm); // Carimba a assinatura digital
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token JWT", exception);
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("MedSystem API")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){

            return "";

        }

    }
    private Instant gerarDataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}