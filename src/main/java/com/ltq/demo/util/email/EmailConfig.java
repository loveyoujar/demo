package com.ltq.demo.util.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import java.util.Properties;

/**
 * 发送Email配置类
 * @author LTQ
 */
@Component
public class EmailConfig {
 
	@Value("${stmp.host}")
	private String host;
	@Value("${stmp.account}")
	private String account;
	@Value("${stmp.password}")
	private String password;
 
	@Value("${mail.smtp.auth}")
	private String isAuth;
	@Value("${mail.smtp.timeout}")
	private String outTime;
 
	@Bean(name = "JavaMailSenderImpl")
	public JavaMailSenderImpl getMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(host);
		javaMailSender.setUsername(account);
		javaMailSender.setPassword(password);
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", isAuth);
		properties.put("mail.smtp.timeout", outTime);
		javaMailSender.setJavaMailProperties(properties);
		return javaMailSender;
	}
 
	public void sendSimpleMail(EmailEntity email) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(account);
		String receiver = email.getReceiver();
		String receivers[] = receiver.split(";");
		simpleMailMessage.setTo(receivers);
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setText(email.getContent());
		getMailSender().send(simpleMailMessage);
	}
 
}
