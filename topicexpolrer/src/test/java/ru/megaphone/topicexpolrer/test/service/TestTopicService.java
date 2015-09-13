package ru.megaphone.topicexpolrer.test.service;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import ru.megaphone.topicexpolrer.service.DefaultTopicService;
import ru.megaphone.topicexpolrer.service.TopicExplorerService;
import ru.megaphone.topicexpolrer.util.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;



public class TestTopicService  {

	public static File rootRepositoryDir;
	
	public final static String TEST_FILE_NAME="offset.csv";
	
	@ClassRule
	public static TemporaryFolder tempFolder = new TemporaryFolder();
	
	@BeforeClass
	public static void setUpRepository() throws IOException{
		rootRepositoryDir =  tempFolder.newFolder("test");
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history/1990-12-22-05-12-51/").mkdir();
		File launchFolder = new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history/1990-12-22-05-12-51/");
		File testOffsetFile = new File(launchFolder.getAbsolutePath()+"/"+TEST_FILE_NAME);
		FileWriter fileWriter = new FileWriter(testOffsetFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("100,200");
		bufferedWriter.newLine();
		bufferedWriter.write("101,100");
		bufferedWriter.newLine();
		bufferedWriter.write("102,"+10);
		bufferedWriter.close();
	}
	
	@Test
	public void doTestListTopic() throws IOException{
		
		ApplicationContext.setApplicationDirectory(rootRepositoryDir.getAbsolutePath());
		TopicExplorerService topicService = new DefaultTopicService();
		ObjectMapper mapper = new ObjectMapper();
		String topicListResult = mapper.writeValueAsString(topicService.getTopicInDirectory());
		assertEquals("{\"topicList\":[\"topic1\"]}", topicListResult);
	}
	
	@Test
	public void doTestLastLaunchProcedureList() throws IOException{
		
		ApplicationContext.setApplicationDirectory(rootRepositoryDir.getAbsolutePath());
		TopicExplorerService topicService = new DefaultTopicService();
		ObjectMapper mapper = new ObjectMapper();
		String topicListResult = mapper.writeValueAsString(topicService.getLastLaunchTopicProcedureList());
		assertEquals("{\"topicLaunchMap\":{\"topic1\":\"1990-12-22T05:12:51Z\"}}", topicListResult);
	}
	
	@Test
	public void doTestPartisionList() throws IOException{
		ApplicationContext.setApplicationDirectory(rootRepositoryDir.getAbsolutePath());
		TopicExplorerService topicService = new DefaultTopicService();
		ObjectMapper mapper = new ObjectMapper();
		String topicListResult = mapper.writeValueAsString(topicService.getPartisionLaunchStatistic());
		assertEquals("{\"topicLastLaunchDataMap\":{\"topic1\":[{\"PartisionNumber\":100,\"MessageCount\":200},{\"PartisionNumber\":101,\"MessageCount\":100},{\""
				+ "PartisionNumber\":102,\"MessageCount\":10}]}}", topicListResult);
	}
	
	
	@Test
	public void doTestLaunchStatistic() throws IOException{
		ApplicationContext.setApplicationDirectory(rootRepositoryDir.getAbsolutePath());
		TopicExplorerService topicService = new DefaultTopicService();
		ObjectMapper mapper = new ObjectMapper();
		String topicListResult = mapper.writeValueAsString(topicService.getLaunchStatisticMap());
		assertEquals("{\"topicStatisticMap\":{\"topic1\":{\"summaryMessages\":\"310\",\"minimumMessagesInPartision\":\"10\","
				+ "\"maximumMessagesInPartision\":\"200\",\"avregeMessageCountInPartision\":\"103\"}}}", topicListResult);
	}
}
