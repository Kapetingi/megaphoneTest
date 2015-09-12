package ru.megaphone.topicexpolrer.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.megaphone.topicexpolrer.model.LaunchStatistic;
import ru.megaphone.topicexpolrer.model.PartisionItem;
import ru.megaphone.topicexpolrer.model.Topic;

public class TopicPartisionListMessage {

	Map<String,List<PartisionItem>> topicLastLaunchDataMap;
	
	public TopicPartisionListMessage(List<Topic> topicList){
		topicLastLaunchDataMap= new HashMap<String, List<PartisionItem>>();
		for(Topic topic: topicList){
			List<LaunchStatistic> statisticList = topic.getLatestLaunchProcedure().getListLaunchStatistic();
			List<PartisionItem> partisionsItemList = statisticList.get(0).getPartisionsFromStatistics();
			topicLastLaunchDataMap.put(topic.getTopicName(),partisionsItemList);
		}
	}

	public Map<String, List<PartisionItem>> getTopicLastLaunchDataMap() {
		return topicLastLaunchDataMap;
	}

	public void setTopicLastLaunchDataMap(
			Map<String, List<PartisionItem>> topicLastLaunchDataMap) {
		this.topicLastLaunchDataMap = topicLastLaunchDataMap;
	}

}
