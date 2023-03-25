package com.br.apiemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiemail.mensagem.DadosMensagem;

@RestController
@RequestMapping("/emailsimples")
public class EmailSimples {

	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping
	public void enviar(@RequestBody DadosMensagem mensagem) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

	    simpleMailMessage.setTo(mensagem.destinatario().toArray(new String[mensagem.destinatario().size()]));
		simpleMailMessage.setCc(mensagem.copia().toArray(new String[mensagem.copia().size()]));

		simpleMailMessage.setSubject(mensagem.assunto());
		simpleMailMessage.setText(mensagem.corpo());

		javaMailSender.send(simpleMailMessage);

	}

}
