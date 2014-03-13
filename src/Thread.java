import java.util.*; import java.io.*;
public class Thread {
	public static String StartCommand = "java -version";
	public static String EndCommand = "java -version";
	public static String HiberCommand = "java -version";
	public static int onTimeHour, onTimeMinute, offTimeHour, offTimeMinute;
	public static boolean override = false;
	public static Log log;
	
	public static void main(String args[]) {
		Display x = new Display();
		x.Output.setText("AMDGS Software 2.0");
		
		log = new Log();
		boolean serverRunning = false;
		log.write("Server set to default state: off");
		
		try {
			Scanner in = new Scanner(new File("Schedule.txt"));
			onTimeHour = in.nextInt();
			onTimeMinute = in.nextInt();
			offTimeHour = in.nextInt();
			offTimeMinute = in.nextInt();
			log.write("Successfully read Schedule.txt configuration.");
			in.close(); }
		catch (FileNotFoundException e) {
			e.printStackTrace();
			log.write("ERROR: unable to read Schedule.txt configuration."); }
		
		log.write("Loading finished.");
		log.write("Main loop initialized.");
		int currentDay = 0;
		while (true) {
			if (currentHour() < offTimeHour) serverRunning = true;
			else if (currentHour() == offTimeHour && currentMinute() < offTimeMinute) serverRunning = true;
			else if (currentHour() < onTimeHour) serverRunning = false;
			else if (currentHour() == onTimeHour && currentMinute() < onTimeMinute) serverRunning = false;
			
			if (override) serverRunning = true;
		
			if (serverRunning) x.Status.setText("The server is currently running.");
			else x.Status.setText("The server is off and hibernating.");
			
			if (currentDay() != currentDay) {
				currentDay = currentDay();
				log.write(" ");
				log.write(currentMonth() + "/" + currentDay() + "/" + currentYear() + " -");
			}
		}
		
		//runCommand("java -jar F:/TST/Flatspace.jar");
	}
	
	public static void runCommand(String s) {
		try {Runtime.getRuntime().exec(s); }
		catch (Exception E) {E.printStackTrace(); } }
	
	public static int currentHour() {return Calendar.getInstance().get(Calendar.HOUR_OF_DAY); }
	public static int currentMinute() {return Calendar.getInstance().get(Calendar.MINUTE); }
	public static int currentDay() {return Calendar.getInstance().get(Calendar.DAY_OF_MONTH); }
	public static int currentMonth() {return Calendar.getInstance().get(Calendar.MONTH) + 1; }
	public static int currentYear() {return Calendar.getInstance().get(Calendar.YEAR); }
}
