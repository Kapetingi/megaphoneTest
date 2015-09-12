package ru.megaphone.topicexpolrer.view;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.megaphone.topicexpolrer.model.Topic;

public class TopicLaunchDateMessage {
	
	private Map<String,String> topicLaunchMap;
	
	public TopicLaunchDateMessage(List<Topic> listOfTopic){
		topicLaunchMap = new HashMap<String, String>();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		for(Topic topic:listOfTopic){
			topicLaunchMap.put(topic.getTopicName(), dateFormatter.format(topic.getLatestLaunchProcedure().getLaunchProcedureDate()));
		}
	}

	public Map<String,String> getTopicLaunchMap() {
		return topicLaunchMap;
	}

}
