package automationFramework.Utilities;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;

public class Logging {

	private static Logger Log = Logger.getLogger(Logger.class.getName());

	public static void setLogConsole() {
		// Logging Configuration
		DOMConfigurator.configure("log4j.xml");
		ConsoleAppender ConsoleAppender = new ConsoleAppender();
		ConsoleAppender.setLayout(new SimpleLayout());
		Log.addAppender(ConsoleAppender);
		ConsoleAppender.activateOptions();
	}

	public static void setLogFile() {
		DOMConfigurator.configure("log4j.xml");
		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile(Constant.LOG_FILE);
		fileAppender.setLayout(new SimpleLayout());
		Log.addAppender(fileAppender);
		fileAppender.activateOptions();
	}
}
