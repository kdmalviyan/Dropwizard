package com.kd.example.dropwizard.app;

import com.kd.example.dropwizard.config.DropwizardRegisterHelper;
import com.kd.example.dropwizard.config.KUserServiceRestConfiguration;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<KUserServiceRestConfiguration> {

	@Override
	public void run(KUserServiceRestConfiguration configuration, Environment environment) throws Exception {
		DropwizardRegisterHelper.registerResource(configuration, environment);
		DropwizardRegisterHelper.registerHealthChecker(configuration, environment);
	}

	public static void main(String[] args) {
		try {
			String[] configParameters = { "server", "rest-config.yml" };
			new MainApp().run(configParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
