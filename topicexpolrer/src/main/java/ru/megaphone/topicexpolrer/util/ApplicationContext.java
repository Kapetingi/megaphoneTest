package ru.megaphone.topicexpolrer.util;

public class ApplicationContext {
	
	private static String applicationDirectory;
	
	private ApplicationContext(){
		
	}

	public static String getApplicationDirectory() {
		return applicationDirectory;
	}

	public static void setApplicationDirectory(String applicationDir) {
		applicationDirectory = applicationDir;
	}

}
