package ru.megaphone.topicexpolrer.test.model;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import ru.megaphone.topicexpolrer.model.LaunchProcedure;
import ru.megaphone.topicexpolrer.model.Topic;


public class TopicTest {
	
private static File rootRepositoryDir;
	
	@ClassRule
	public static TemporaryFolder tempFolder = new TemporaryFolder();
	
	@BeforeClass
	public static void setUpRepository() throws IOException{
		rootRepositoryDir =  tempFolder.newFolder("test");
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history/1990-12-22-05-12-51").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history/1996-02-22-15-17-31").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history/2015-01-12-09-58-51").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic1/history/1998-10-02-19-17-41").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic2").mkdir();
		new File(rootRepositoryDir.getAbsolutePath()+"/topic2/history").mkdir();
	}
	
	@Test
	public void getAllLaunchTest(){
		Topic topic = new Topic(new File(rootRepositoryDir.getAbsolutePath()+"/topic1/"));
		List<LaunchProcedure> launchList = topic.getLaunchOfProcedureFromTopic();
		Set<Date> allLaunchProcedureDate =  new HashSet<Date>(launchList.stream().map(x->x.getLaunchProcedureDate()).collect(Collectors.toList()));
		assertEquals(true,allLaunchProcedureDate.contains(new GregorianCalendar(1990, 11, 22, 5, 12, 51).getTime()));
		assertEquals(true,allLaunchProcedureDate.contains(new GregorianCalendar(1996, 1, 22, 15, 17, 31).getTime()));
		assertEquals(true,allLaunchProcedureDate.contains(new GregorianCalendar(2015, 0, 12, 9, 58, 51).getTime()));
		assertEquals(true,allLaunchProcedureDate.contains(new GregorianCalendar(1998, 9, 2, 19, 17, 41).getTime()));
		Topic topic2 = new Topic(new File(rootRepositoryDir.getAbsolutePath()+"/topic2/"));
		assertEquals(true, topic2.getLaunchOfProcedureFromTopic().isEmpty());
	}

}
