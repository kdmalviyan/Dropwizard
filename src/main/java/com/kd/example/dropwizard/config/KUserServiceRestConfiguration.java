package com.kd.example.dropwizard.config;

import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;

public class KUserServiceRestConfiguration extends Configuration {

	@NotNull
	private String template;

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
