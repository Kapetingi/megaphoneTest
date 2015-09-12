package ru.megaphone.topicexpolrer.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TopicRepository {

	private List<Topic> topics;
	private File repositoryFolder;
	
	public TopicRepository(String topicRepositoryDir){
		repositoryFolder = new File(topicRepositoryDir);
		setTopicsInRepository();
	}
	
	private void setTopicsInRepository(){
		topics = new ArrayList<Topic>();
		File[] listOfTopics = repositoryFolder.listFiles();
		
		for(File topic: listOfTopics){
			topics.add(new Topic(topic));
		}
	}
	
	public List<Topic> getTopicsFromRepository(){
		return topics;
	}
}
