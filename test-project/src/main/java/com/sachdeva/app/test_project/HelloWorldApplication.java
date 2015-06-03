package com.sachdeva.app.test_project;

import com.sachdeva.app.health.TemplateHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication  extends Application<HelloWorldConfiguration>{
	
	
	public static void main(String[] args) throws Exception{
		new HelloWorldApplication().run(args);
	}
	@Override
	public void run(HelloWorldConfiguration configuration, Environment environment)
			throws Exception {
		// TODO Auto-generated method stub
		
		final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
		environment.jersey().register(resource);
		
		final TemplateHealthCheck healthCheck =
		        new TemplateHealthCheck(configuration.getTemplate());
		    environment.healthChecks().register("template", healthCheck);
	}
	
	@Override
	public String getName(){
		return "hello-world";
		
	}
	
	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		// TODO Auto-generated method stub
		super.initialize(bootstrap);
	}
	

}
