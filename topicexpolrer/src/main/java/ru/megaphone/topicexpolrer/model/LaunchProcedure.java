package ru.megaphone.topicexpolrer.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LaunchProcedure implements Comparable<LaunchProcedure> {
	
	private Date launchProcedureDate;
	private File launchProcedureFolder;
	private List<LaunchStatistic> listLaunchStatistic; 
	
	public LaunchProcedure(File launchProcedureFolder){
		listLaunchStatistic = new ArrayList<LaunchStatistic>();
		try {
			this.launchProcedureFolder = launchProcedureFolder;
			this.launchProcedureDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(launchProcedureFolder.getName());
			for(File launchStatisic: launchProcedureFolder.listFiles()){
				listLaunchStatistic.add(new LaunchStatistic(launchStatisic));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getLaunchProcedureDate() {
		return launchProcedureDate;
	}

	public void setLaunchProcedureDate(Date launchProcedureDate) {
		this.launchProcedureDate = launchProcedureDate;
	}

	public List<LaunchStatistic> getListLaunchStatistic() {
		return listLaunchStatistic;
	}

	public void setListLaunchStatistic(List<LaunchStatistic> listLaunchStatistic) {
		this.listLaunchStatistic = listLaunchStatistic;
	}
	
	@Override
	public int compareTo(LaunchProcedure o) {
		return this.launchProcedureDate.compareTo(o.getLaunchProcedureDate());
	}

}
