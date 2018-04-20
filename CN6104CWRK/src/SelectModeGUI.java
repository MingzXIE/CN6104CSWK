import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SelectModeGUI {
	private static JFrame modeSelectionFrame;
	public static PrintWriter out;
	public static BufferedReader in;
	
	
	public SelectModeGUI(PrintWriter outIn, BufferedReader inIn){
		out = outIn;
		in = inIn;
	}
	
	public void startGUI(){
		modeSelectionFrame = new JFrame("Select Mode");
		modeSelectionFrame.setSize(300, 300);
		modeSelectionFrame.setLocation(300, 300);
		modeSelectionFrame.setLayout(new GridLayout(5,1));
		modeSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel menuOptions = new JLabel("Select Mode");
		menuOptions.setFont(new Font("Monospace", 1, 27));
		menuOptions.setForeground(Color.WHITE);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(menuOptions);
		topPanel.setBackground(new Color(173, 216, 230));

		JButton practiceButton = new JButton("Practice");
		practiceButton.setPreferredSize(new Dimension(150, 30));
		practiceButton.setFont(new Font("Monospace", 1, 17));
		practiceButton.setActionCommand("Practice");
		practiceButton.addActionListener(new ButtonClickListener());

		JButton friendlyButton = new JButton("Friendly");
		friendlyButton.setPreferredSize(new Dimension(150, 30));
		friendlyButton.setFont(new Font("Monospace", 1, 17));
		friendlyButton.setActionCommand("Friendly");
		friendlyButton.addActionListener(new ButtonClickListener());
		
		JButton tournamentButton = new JButton("Tournament");
		tournamentButton.setPreferredSize(new Dimension(150, 30));
		tournamentButton.setFont(new Font("Monospace", 1, 17));
		tournamentButton.setActionCommand("Tournament");
		tournamentButton.addActionListener(new ButtonClickListener());

		JButton backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(100, 30));
		backButton.setFont(new Font("Monospace", 1, 17));
		backButton.setActionCommand("Back");
		backButton.addActionListener(new ButtonClickListener());

		JPanel practicePanel = new JPanel();
		practicePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		practicePanel.setBackground(Color.WHITE);
		practicePanel.add(practiceButton);

		JPanel friendlyPanel = new JPanel();
		friendlyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		friendlyPanel.setBackground(Color.WHITE);
		friendlyPanel.add(friendlyButton);
		
		JPanel tournamentPanel = new JPanel();
		tournamentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tournamentPanel.setBackground(Color.WHITE);
		tournamentPanel.add(tournamentButton);

		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		backPanel.setBackground(Color.WHITE);
		backPanel.add(backButton);
		
		modeSelectionFrame.add(topPanel);
		modeSelectionFrame.add(practicePanel);
		modeSelectionFrame.add(friendlyPanel);
		modeSelectionFrame.add(tournamentPanel);
		modeSelectionFrame.add(backPanel);
		modeSelectionFrame.setVisible(true);

	}
	
	private static class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch (command) {
			case "Practice":
				try {
					startPracticeMode();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "Friendly":
				try {
					startFriendlyMode();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "Tournament":
				try {
					startTournamentMode();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			
			case "Back":
				modeSelectionFrame.dispose();
				LoginGUI.startGUI();
				break;

			default:
				break;
			}

		}

	}
	
	public static void startPracticeMode() throws  IOException {
		ClientGUI pc = new ClientGUI(out, in, "P");
		modeSelectionFrame.dispose();
	    out.println("#PMODE");
	    String flag=in.readLine();
	    System.out.println(flag);
		pc.startGUI();
		pc.client();
	}
	
	public static void startFriendlyMode() throws  IOException {
		ClientGUI pc = new ClientGUI(out, in, "F");
		modeSelectionFrame.dispose();
	    out.println("#FMODE");
//	    String flag=in.readLine();
//	    System.out.println(flag);
	    pc.startGUI();
	    pc.client();
	}
	
	public static void startTournamentMode() throws  IOException {
		ClientGUI pc = new ClientGUI(out, in, "T");
		modeSelectionFrame.dispose();
	    out.println("#TMODE");
//	    String flag=in.readLine();
//	    System.out.println(flag);
	    pc.startGUI();
	    pc.client();
	}
	
	
}
