package ru.megaphone.topicexpolrer.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Topic {
	
	private static final String DIRECTORY_OF_LAUNCH ="/history";
	
	private File topicDirectory;
	
	private List<LaunchProcedure> launchProcedureList;
	
	public Topic(File topicFolder){
		this.topicDirectory = topicFolder;
		this.launchProcedureList = getLaunchOfProcedureFromTopic();
	}
	
	public List<LaunchProcedure> getLaunchOfProcedureFromTopic(){
		List<LaunchProcedure> result = new ArrayList<LaunchProcedure>();
		File launchingDir = new File(topicDirectory.getAbsolutePath()+DIRECTORY_OF_LAUNCH);
		
		for(File launchDirectory: launchingDir.listFiles()){
			result.add(new LaunchProcedure(launchDirectory));
		}
		return result;
	}
	
	public String getTopicName(){
		return topicDirectory.getName();
	}
	

}
