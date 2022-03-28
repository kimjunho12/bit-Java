package com.example.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Kanbanboard07Application {

	public static void main(String[] args) {
		SpringApplication.run(Kanbanboard07Application.class, args);
	}

	@Bean
	public ApplicationRunner scriptRunner() {
		return new ApplicationRunner() {

			@Autowired
			private SqlSessionFactory sqlSessionFactory;

			@Override
			public void run(ApplicationArguments args) throws Exception {
				ScriptRunner scriptRunner = new ScriptRunner(
						sqlSessionFactory.getConfiguration().getEnvironment().getDataSource().getConnection());
				scriptRunner.runScript(Resources.getResourceAsReader("sql/db-setup.sql"));
			}
		};
	}
}
