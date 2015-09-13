package ru.megaphone.topicexpolrer.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.megaphone.topicexpolrer.util.ApplicationContext;


@SpringBootApplication
public class TopicExplorerApplication {

	final static Logger logger = Logger.getLogger(TopicExplorerApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext.setApplicationDirectory(args[0]);
		SpringApplication.run(TopicExplorerApplication.class,args);
		logger.info("Application TopicExplorer is running");
	}

}
