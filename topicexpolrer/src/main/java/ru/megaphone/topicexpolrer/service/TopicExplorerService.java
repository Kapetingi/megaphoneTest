package ru.megaphone.topicexpolrer.service;

import ru.megaphone.topicexpolrer.view.TopicLaunchDateMessage;
import ru.megaphone.topicexpolrer.view.TopicListMessage;
import ru.megaphone.topicexpolrer.view.TopicPartisionListMessage;
import ru.megaphone.topicexpolrer.view.TopicStatisticMessage;

public interface TopicExplorerService {

	    public  TopicListMessage getTopicInDirectory();
	    
	    public TopicLaunchDateMessage getLastLaunchTopicProcedureList();
	    
	    public  TopicStatisticMessage getLaunchStatisticMap();
	    
	    public TopicPartisionListMessage getPartisionLaunchStatistic();
}
