package ru.megaphone.topicexpolrer.test.model;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import ru.megaphone.topicexpolrer.model.LaunchStatistic;

public class LaunchStatisticTest {
	
	public static String TEST_FILE_NAME = "offsets.csv";
	public static File testOffsetFile;
	
	@ClassRule
	public static TemporaryFolder tempFolder = new TemporaryFolder();
	
	
	@BeforeClass
	public static void createTestOffsetFile(){
		try {
			testOffsetFile = tempFolder.newFile(TEST_FILE_NAME);
			FileWriter fileWriter = new FileWriter(testOffsetFile.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("100,"+Long.MAX_VALUE);
			bufferedWriter.newLine();
			bufferedWriter.write("101,"+Long.MAX_VALUE);
			bufferedWriter.newLine();
			bufferedWriter.write("102,"+1);
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllMessageCount(){
		LaunchStatistic launchStatistic = new LaunchStatistic(testOffsetFile);
		BigDecimal chekedResult = new BigDecimal(1);
		chekedResult=chekedResult.add(new BigDecimal(Long.MAX_VALUE));
		chekedResult=chekedResult.add(new BigDecimal(Long.MAX_VALUE));
		assertEquals(chekedResult,launchStatistic.getAllMessageCount());
	}
	
	@Test 
	public void testGetMaximumMessage(){
		LaunchStatistic launchStatistic = new LaunchStatistic(testOffsetFile);
		assertEquals(Long.MAX_VALUE, launchStatistic.getMaximumMessageCount());
	}
	
	@Test
	public void testGetMinimumMessageCount(){
		LaunchStatistic launchStatistic = new LaunchStatistic(testOffsetFile);
		assertEquals(1, launchStatistic.getMinimumMessageCount());
	}
	
	@Test
	public void testGetAvregeMessageCount(){
		LaunchStatistic launchStatistic = new LaunchStatistic(testOffsetFile);
		BigDecimal chekedResult = new BigDecimal(1);
		chekedResult=chekedResult.add(new BigDecimal(Long.MAX_VALUE));
		chekedResult=chekedResult.add(new BigDecimal(Long.MAX_VALUE));
		assertEquals(chekedResult.divide(new BigDecimal(3)).longValue(), launchStatistic.getAverageMessageCount());
	}
}
