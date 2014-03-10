import java.util.Calendar;

public class Thread {
	public static String StartCommand = "java -version";
	public static String EndCommand = "java -version";
	public static String HiberCommand = "java -version";
	
	public static void main(String args[]) {
		Display x = new Display();
		x.Output.setText("AMDGS Software 2.0");
		boolean serverRunning = false;
		while (true) {
			if (currentHour() == 9 && currentMinute() == 5 && !serverRunning) serverRunning = true;
			if (currentHour() == 9 && currentMinute() == 6 && serverRunning) serverRunning = false;
			
			if (serverRunning) x.Status.setText("The server is currently running.");
			else x.Status.setText("The server is off and hibernating.");
		}
		
		//runCommand("java -jar F:/TST/Flatspace.jar");
	}
	
	public static void runCommand(String s) {
		try {Runtime.getRuntime().exec(s); }
		catch (Exception E) {E.printStackTrace(); } }
	
	public static int currentHour() {return Calendar.getInstance().get(Calendar.HOUR_OF_DAY); }
	public static int currentMinute() {return Calendar.getInstance().get(Calendar.MINUTE); }

	
	
}
