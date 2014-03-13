import javax.swing.*; import java.awt.*; import java.awt.event.*; import java.io.*;
public class Log extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JButton saveButton;
	public static JTextArea logbox;
	public static JScrollPane scrollingPane;
	public Log() {
		super("Console Log");
		JPanel mainPanel = new JPanel(new BorderLayout(2, 1));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch (Exception E) {E.printStackTrace(); }
		logbox = new JTextArea(5,20);
		scrollingPane = new JScrollPane(logbox);
		scrollingPane.setPreferredSize(new Dimension(700, 200));
		logbox.setEditable(false);
		mainPanel.add(scrollingPane, BorderLayout.PAGE_START);
		saveButton = new JButton("Save Log");
		saveButton.addActionListener(new ApplyListener());
		saveButton.setPreferredSize(new Dimension(100, 50));
		mainPanel.add(saveButton, BorderLayout.PAGE_END);
		setContentPane(mainPanel);
		logbox.append("AGS 2.0 Software Log activated.");
		logbox.setFont(new Font("SansSerif", Font.PLAIN, 11));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
		setSize(400, 290);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 200, (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 100); }
	public void write(String s) {
		if (Thread.currentMinute() < 10) logbox.append("\n" + Thread.currentHour() + ":0" + Thread.currentMinute() + " - " + s);
		else logbox.append("\n" + Thread.currentHour() + ":" + Thread.currentMinute() + " - " + s);
		logbox.setCaretPosition(logbox.getDocument().getLength()); }
	private class ApplyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			PrintWriter out = null;
			try {out = new PrintWriter(new File("Log-" + Thread.currentMonth() + "-" + Thread.currentDay() + "-" + Thread.currentYear() + ".txt"));}
			catch (FileNotFoundException e) {e.printStackTrace(); }
			out.print(logbox.getText());
			write("The log has been saved to the file: Log-" + Thread.currentMonth() + "-" + Thread.currentDay() + "-" + Thread.currentYear() + ".txt");
			out.close(); } } }
