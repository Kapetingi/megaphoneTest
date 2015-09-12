package ru.megaphone.topicexpolrer.test.model;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import ru.megaphone.topicexpolrer.model.Topic;
import ru.megaphone.topicexpolrer.model.TopicRepository;

public class TopicRepositoryTest {
	
	public static File rootRepositoryDir;
	
	@ClassRule
	public static TemporaryFolder tempFolder = new TemporaryFolder();
	
	@BeforeClass
	public static void setUpRepository() throws IOException{
		rootRepositoryDir =  tempFolder.newFolder("test");
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic2").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic2/history").mkdir();
	}
	
	@Test
	public void testGetTopic(){
		TopicRepository topicRepository =  new TopicRepository(rootRepositoryDir.getAbsolutePath());
		List<Topic> topics =  topicRepository.getTopicsFromRepository();
		assertEquals("topic1",topics.get(0).getTopicName());
		assertEquals("topic2",topics.get(1).getTopicName());
	}

}
