package ru.megaphone.topicexpolrer.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.megaphone.topicexpolrer.model.LaunchStatistic;
import ru.megaphone.topicexpolrer.model.Topic;


public class TopicStatisticMessage {
	
	class TopicLaunchStatisticItem{
		public String summaryMessages;
		public String minimumMessagesInPartision;
		public String maximumMessagesInPartision;
		public String avregeMessageCountInPartision;
		
		
		public TopicLaunchStatisticItem(String summaryCount, String minimumCount, String maximumCount, String avregeCount){
			this.summaryMessages = summaryCount;
			this.maximumMessagesInPartision= maximumCount;
			this.minimumMessagesInPartision = minimumCount;
			this.avregeMessageCountInPartision=avregeCount;
			
		}
	}
	
	Map<String,TopicLaunchStatisticItem> topicStatisticMap;
	
	public TopicStatisticMessage(List<Topic> topicList){
		topicStatisticMap = new HashMap<String,TopicStatisticMessage.TopicLaunchStatisticItem>();
		for(Topic topic: topicList){
			LaunchStatistic launchStatistic = topic.getLatestLaunchProcedure().getListLaunchStatistic().get(0);
			topicStatisticMap.put(topic.getTopicName(),new TopicLaunchStatisticItem(launchStatistic.getAllMessageCount().toString(),
					String.valueOf(launchStatistic.getMinimumMessageCount()), String.valueOf(launchStatistic.getMaximumMessageCount()),
					String.valueOf(launchStatistic.getAverageMessageCount())));
		}
		
	}

	public Map<String, TopicLaunchStatisticItem> getTopicStatisticMap() {
		return topicStatisticMap;
	}

	public void setTopicStatisticMap(
			Map<String, TopicLaunchStatisticItem> topicStatisticMap) {
		this.topicStatisticMap = topicStatisticMap;
	}


}
