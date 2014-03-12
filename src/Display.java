import javax.swing.*; import java.awt.*; import java.awt.event.*;
public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	public Display() {
		super("AGS 2.0");
		JPanel mainPanel = new JPanel(new GridLayout(4, 1));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch (Exception E) {E.printStackTrace(); }
		
		Output = new JLabel();
		mainPanel.add(Output);
		
		ToggleStart = new JButton("Start/Stop");
		ToggleStart.addActionListener(new OSDListener());
		mainPanel.add(ToggleStart);
		
		TaskBar = new JProgressBar();
		TaskBar.setMaximum(100);
		mainPanel.add(TaskBar);
		
		Status = new JLabel("Loading server...");
		mainPanel.add(Status);
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
		setSize(400, 200);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 200, (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 100); }
	public JLabel Output, Status;
	public JButton ToggleStart;
	public JProgressBar TaskBar;
	
	private class OSDListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Potato!");
		} }

}
