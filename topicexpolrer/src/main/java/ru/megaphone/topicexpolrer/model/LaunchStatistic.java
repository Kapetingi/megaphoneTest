package ru.megaphone.topicexpolrer.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class LaunchStatistic {
	
	private final static String STANDART_FILE_NAME ="offsets.csv"; 

	File launchStatisticFile; 
	
	List<PartisionItem> partisionsInStatistic;
	
	public LaunchStatistic(File absoluteFilePath){
		launchStatisticFile = absoluteFilePath;//new File(absoluteFilePath+"/"+STANDART_FILE_NAME);
		partisionsInStatistic = readFileStatistic();
	}
	
	private List<PartisionItem> readFileStatistic(){
		List<PartisionItem> result = new ArrayList<PartisionItem>();
		String readLine;
		try(BufferedReader reader = new BufferedReader(new FileReader(launchStatisticFile));) {
			readLine = reader.readLine();
			while(readLine!=null){
				String[] columnValue = readLine.split(",");
				result.add(new PartisionItem(Integer.valueOf(columnValue[0]),Long.valueOf(columnValue[1])));
				readLine = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public BigDecimal getAllMessageCount(){
		BigDecimal result = new BigDecimal(0);
		for(PartisionItem partisionItem : partisionsInStatistic){
			result = result.add(new BigDecimal(partisionItem.MessageCount));
		}
		return result;
	}
	
	public long getMinimumMessageCount(){
		long result = Long.MAX_VALUE;
		for(PartisionItem partisionItem : partisionsInStatistic){
			if (result > partisionItem.MessageCount)
				result = partisionItem.MessageCount;
		}
		return result;
	}
	
	public long getMaximumMessageCount(){
		long result = Long.MIN_VALUE;
		for(PartisionItem partisionItem : partisionsInStatistic){
			if (result < partisionItem.MessageCount)
				result = partisionItem.MessageCount;
		}
		return result;
	}
	
	public long getAverageMessageCount(){
		BigDecimal result = new BigDecimal(0);
		BigDecimal partisionCount = new BigDecimal(0);
		for(PartisionItem partisionItem : partisionsInStatistic){
			result = result.add(new BigDecimal(partisionItem.MessageCount));
			partisionCount = partisionCount.add(new BigDecimal(1));
		}
		return result.divide(partisionCount,RoundingMode.HALF_UP).longValue();
	}
	
	public List<PartisionItem> getPartisionsFromStatistics(){
		return partisionsInStatistic;
	}

}
