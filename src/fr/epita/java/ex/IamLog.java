/**
 * 
 */
package fr.epita.java.ex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mikael
 *
 */
public class IamLog {
	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss.SSS");
	private PrintWriter writer;
	IamLog(String loggingEntity) {
		super();
		File logFile = new File("log.txt");
		if(!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				this.writer = new PrintWriter(new FileWriter(logFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.writer.println("Start logging...");
			this.writer.flush();
		}
		this.loggingEntity = loggingEntity;
	}
	
	public void log(String msg, Level level) {
		String trace = sdf.format(new Date()) + " " + loggingEntity + " - [" + level + "] - " + msg;
		System.out.println(trace);
		this.writer.println(trace);
		this.writer.flush();
	}

	private String loggingEntity;
	
	public void info(String message) {
		log(message, Level.INFO);
	}
	
	public void debug(String message) {
		log(message, Level.DEBUG);
	}
	
	public void warning(String message) {
		log(message, Level.WARN);
	}
	
	public void log(String message) {
		log(message, Level.LOG);
	}
	
	public void error(String message) {
		log(message, Level.ERROR);
	}
}
