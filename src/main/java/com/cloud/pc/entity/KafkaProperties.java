package com.cloud.pc.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
@ComponentScan
@PropertySource("classpath:/application.properties")
@EnableAutoConfiguration
public class KafkaProperties {

	@Value("${CLOUDKARAFKA_TOPIC_PREFIX}")
	private String CLOUDKARAFKA_TOPIC_PREFIX;
	
	public String getCLOUDKARAFKA_TOPIC_PREFIX() {
		return CLOUDKARAFKA_TOPIC_PREFIX;
	}

	public void setCLOUDKARAFKA_TOPIC_PREFIX(String cLOUDKARAFKA_TOPIC_PREFIX) {
		CLOUDKARAFKA_TOPIC_PREFIX = cLOUDKARAFKA_TOPIC_PREFIX;
	}

	public String getCLOUDKARAFKA_BROKERS() {
		return CLOUDKARAFKA_BROKERS;
	}

	public void setCLOUDKARAFKA_BROKERS(String cLOUDKARAFKA_BROKERS) {
		CLOUDKARAFKA_BROKERS = cLOUDKARAFKA_BROKERS;
	}

	@Value("${CLOUDKARAFKA_BROKERS}")
	private String CLOUDKARAFKA_BROKERS;
	
	@Value("${CLOUDKARAFKA_CA}")
	private String CLOUDKARAFKA_CA;
	@Value("${CLOUDKARAFKA_CERT}")
	private String CLOUDKARAFKA_CERT;
	@Value("${CLOUDKARAFKA_PRIVATE_KEY}")
	private String CLOUDKARAFKA_PRIVATE_KEY;

	public String getCLOUDKARAFKA_CA() {
		return CLOUDKARAFKA_CA;
	}

	public void setCLOUDKARAFKA_CA(String cLOUDKARAFKA_CA) {
		CLOUDKARAFKA_CA = cLOUDKARAFKA_CA;
	}

	public String getCLOUDKARAFKA_CERT() {
		return CLOUDKARAFKA_CERT;
	}

	public void setCLOUDKARAFKA_CERT(String cLOUDKARAFKA_CERT) {
		CLOUDKARAFKA_CERT = cLOUDKARAFKA_CERT;
	}

	public String getCLOUDKARAFKA_PRIVATE_KEY() {
		return CLOUDKARAFKA_PRIVATE_KEY;
	}

	public void setCLOUDKARAFKA_PRIVATE_KEY(String cLOUDKARAFKA_PRIVATE_KEY) {
		CLOUDKARAFKA_PRIVATE_KEY = cLOUDKARAFKA_PRIVATE_KEY;
	}
	
	
}
