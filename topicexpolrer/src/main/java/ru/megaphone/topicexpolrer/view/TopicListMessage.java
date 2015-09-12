package ru.megaphone.topicexpolrer.view;

import java.util.ArrayList;
import java.util.List;

import ru.megaphone.topicexpolrer.model.Topic;

public class TopicListMessage {

	private List<String> topicList;

	public TopicListMessage(List<Topic> topicList){
		this.topicList = new ArrayList<String>();
		for(Topic item: topicList){
			this.topicList.add(item.getTopicName());
		}
	}
	
	public List<String> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<String> topicList) {
		this.topicList = topicList;
	}
	
}

