package ru.megaphone.topicexpolrer.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ru.megaphone.topicexpolrer.model.TopicRepository;
import ru.megaphone.topicexpolrer.util.ApplicationContext;
import ru.megaphone.topicexpolrer.view.TopicLaunchDateMessage;
import ru.megaphone.topicexpolrer.view.TopicListMessage;
import ru.megaphone.topicexpolrer.view.TopicPartisionListMessage;
import ru.megaphone.topicexpolrer.view.TopicStatisticMessage;

@Service
@Repository("TopicExplorerServce")
public class DefaultTopicService implements TopicExplorerService {
	
	    public TopicListMessage getTopicInDirectory() {
	    	TopicRepository repository = new TopicRepository(ApplicationContext.getApplicationDirectory());
	        return new TopicListMessage(repository.getTopicsFromRepository());
	    }
	    
	    public TopicLaunchDateMessage getLastLaunchTopicProcedureList(){
	    	TopicRepository repository = new TopicRepository(ApplicationContext.getApplicationDirectory());
	    	return new TopicLaunchDateMessage(repository.getTopicsFromRepository());
	    }
	    
	    public TopicStatisticMessage getLaunchStatisticMap(){
	    	TopicRepository repository = new TopicRepository(ApplicationContext.getApplicationDirectory());
	       	return new TopicStatisticMessage(repository.getTopicsFromRepository());
	    }
	    
	    public TopicPartisionListMessage getPartisionLaunchStatistic(){
	    	TopicRepository repository = new TopicRepository(ApplicationContext.getApplicationDirectory());
	       	return new TopicPartisionListMessage(repository.getTopicsFromRepository());
	    }

}
