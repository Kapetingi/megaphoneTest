package ru.megaphone.topicexpolrer.model;

public class PartisionItem {
	
	public PartisionItem(int partNumber, long messageCount){
		this.PartisionNumber = partNumber;
		this.MessageCount = messageCount;
	}
	
	public int PartisionNumber;
	
	public long MessageCount;

}
