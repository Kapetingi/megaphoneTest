package ru.megaphone.topicexpolrer.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.megaphone.topicexpolrer.util.ApplicationContext;


@SpringBootApplication
public class TopicExplorerApplication {

	public static void main(String[] args) {
		ApplicationContext.setApplicationDirectory(args[0]);
		SpringApplication.run(TopicExplorerApplication.class,args);
	}

}
