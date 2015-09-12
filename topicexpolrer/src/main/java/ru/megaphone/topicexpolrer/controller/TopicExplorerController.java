package ru.megaphone.topicexpolrer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.megaphone.topicexpolrer.service.TopicExplorerService;
import ru.megaphone.topicexpolrer.view.TopicLaunchDateMessage;
import ru.megaphone.topicexpolrer.view.TopicListMessage;
import ru.megaphone.topicexpolrer.view.TopicPartisionListMessage;
import ru.megaphone.topicexpolrer.view.TopicStatisticMessage;

@RestController
@ComponentScan(basePackages = {"ru.megaphone.topicexpolrer.service"})
public class TopicExplorerController {
	
		@Autowired
		TopicExplorerService topicService;

	    @RequestMapping(value="/topiclist")
	    public @ResponseBody TopicListMessage getTopicInDirectory() {
	    	return topicService.getTopicInDirectory();
	    }
	    
	    @RequestMapping(value="/lastLaunchList")
	    public @ResponseBody TopicLaunchDateMessage getLastLaunchTopicProcedureList(){
	    	return topicService.getLastLaunchTopicProcedureList();
	    }
	    
	    @RequestMapping(value="/topicLaunchStatistic")
	    public @ResponseBody TopicStatisticMessage getLaunchStatisticMap(){
	    	return topicService.getLaunchStatisticMap();
	    }
	    
	    @RequestMapping(value="/topicLaunchPartision")
	    public @ResponseBody TopicPartisionListMessage getPartisionLaunchStatistic(){
	    	return topicService.getPartisionLaunchStatistic();
	    }
}
