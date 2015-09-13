package ru.megaphone.topicexpolrer.controller;

import org.apache.log4j.Logger;
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
	
	final static Logger logger = Logger.getLogger(TopicExplorerController.class);

	@Autowired
	TopicExplorerService topicService;

    @RequestMapping(value="/topiclist")
    public @ResponseBody TopicListMessage getTopicInDirectory() {
    	logger.debug("GET request: URL '/topiclist'");
    	return topicService.getTopicInDirectory();
    }
    
    @RequestMapping(value="/lastLaunchList")
    public @ResponseBody TopicLaunchDateMessage getLastLaunchTopicProcedureList(){
    	logger.debug("GET request: URL '/lastLaunchList'");
    	return topicService.getLastLaunchTopicProcedureList();
    }
    
    @RequestMapping(value="/topicLaunchStatistic")
    public @ResponseBody TopicStatisticMessage getLaunchStatisticMap(){
    	logger.debug("GET request: URL '/topicLaunchStatistic'");
    	return topicService.getLaunchStatisticMap();
    }
    
    @RequestMapping(value="/topicLaunchPartision")
    public @ResponseBody TopicPartisionListMessage getPartisionLaunchStatistic(){
    	logger.debug("GET request: URL '/topicLaunchPartision'");
    	return topicService.getPartisionLaunchStatistic();
    }
}
