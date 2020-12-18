package finalproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.CardLayout;
import java.awt.Point;
import javax.swing.JEditorPane;
import java.awt.Font;

public class App extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_2 = new JPanel();
	private Boolean playing = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public App() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("/home/eli/eclipse-workspace/FinalProject/src/finalproject/Level.csv"));
		String line = "";
		String playerX = "";
		String playerY = "";
		String scienceX = "";
		String scienceY = "";
		String obstacle1X = "";
		String obstacle1Y = "";
		String obstacle2X = "";
		String obstacle2Y = "";
		String obstacle3X = "";
		String obstacle3Y = "";
		for (int i = 0; i < 10; i++)
    	{
    		line = reader.readLine();
			if (i == 0) {
				playerX = line;
			} else if (i == 1) {
				playerY = line;
			} else if (i == 2) {
				scienceX = line;
			}else if (i == 3) {
				scienceY = line;
			}else if (i == 4) {
				obstacle1X = line;
			}else if (i == 5) {
				obstacle1Y = line;
			}else if (i == 6) {
				obstacle2X = line;
			}else if (i == 7) {
				obstacle2Y = line;
			}else if (i == 8) {
				obstacle3X = line;
			}else if (i == 9) {
				obstacle3Y = line;
			}
			
			
    	}
		
		
		Queue<Instruction> instructionQueue = new LinkedList<Instruction>();
		Queue<JLabel> instructionLabelQueue = new LinkedList<JLabel>();
		setMinimumSize(new Dimension(720, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 412);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(100, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblEnt = new JLabel("Enter Instructions");
		panel_1.add(lblEnt);
		
		String[] directions = {"Choose a direction", "Up", "Down", "Left", "Right"};
		JComboBox directionChoice = new JComboBox(directions);
		panel_1.add(directionChoice);
		
		String[] distances = {"Choose a distance", "1", "2", "3", "4", "5"};
		JComboBox distanceChoice = new JComboBox(distances);
		panel_1.add(distanceChoice);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setActionCommand("Submitted");
		
		panel_1.add(btnSubmit);
		panel_2.setBounds(new Rectangle(300, 0, 0, 0));
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCurrentQueue = new JLabel("Current queue:");
		lblCurrentQueue.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblCurrentQueue, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnGo = new JButton("Send Instruction");
		panel_2.add(btnGo, BorderLayout.SOUTH);
		btnGo.setActionCommand("Go");
		
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("Submitted".equals(e.getActionCommand())) {
					if (playing) {
						if (directionChoice.getSelectedIndex() != 0 && distanceChoice.getSelectedIndex() != 0) {
							Instruction newInstruction = new Instruction(directionChoice.getSelectedIndex(), distanceChoice.getSelectedIndex());
							instructionQueue.add(newInstruction);
							JLabel lblNewLabel = new JLabel(newInstruction.toString());
							instructionLabelQueue.add(lblNewLabel);
							directionChoice.setSelectedIndex(0);
							distanceChoice.setSelectedIndex(0);
							panel.add(lblNewLabel);
							panel.updateUI();
						}
					}
				}
			}
		});
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(0, 0, 139));
		layeredPane.setMinimumSize(new Dimension(500, 500));
		layeredPane.setSize(new Dimension(500, 500));
		layeredPane.setBounds(new Rectangle(0, 0, 500, 500));
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane.add(layeredPane_1, BorderLayout.CENTER);
		
		JLabel player = new JLabel("");
		player.setBounds(Integer.valueOf(playerX), Integer.valueOf(playerY), 60, 60);
		layeredPane_1.add(player);
		player.setIcon(new ImageIcon(App.class.getResource("/sprites/marsrobot.png")));
		
		JLabel lblYouWin = new JLabel("You Win!");
		lblYouWin.setVisible(false);
		lblYouWin.setOpaque(true);
		lblYouWin.setFont(new Font("Montserrat Black", Font.BOLD, 52));
		layeredPane_1.setLayer(lblYouWin, 1);
		lblYouWin.setBounds(139, 147, 273, 65);
		layeredPane_1.add(lblYouWin);
		
		JLabel lblYouLose = new JLabel("You Lose");
		lblYouLose.setVisible(false);
		lblYouLose.setOpaque(true);
		lblYouLose.setFont(new Font("Montserrat Black", Font.BOLD, 52));
		layeredPane_1.setLayer(lblYouLose, 2);
		lblYouLose.setBounds(139, 147, 273, 65);
		layeredPane_1.add(lblYouLose);
		
		JLabel science = new JLabel("");
		science.setBounds(Integer.valueOf(scienceX), Integer.valueOf(scienceY), 60, 60);
		layeredPane_1.add(science);
		science.setIcon(new ImageIcon(App.class.getResource("/sprites/science.png")));
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 562, 368);
		layeredPane_1.add(background);
		background.setIcon(new ImageIcon(App.class.getResource("/sprites/Ladon-basin-in-full-color.jpg")));
		
		JLabel obstacle1 = new JLabel("");
		layeredPane_1.setLayer(obstacle1, 1);
		obstacle1.setIcon(new ImageIcon(App.class.getResource("/sprites/obstacle.png")));
		obstacle1.setBounds(Integer.valueOf(obstacle1X), Integer.valueOf(obstacle1Y), 60, 60);
		layeredPane_1.add(obstacle1);
		
		JLabel obstacle2 = new JLabel("");
		layeredPane_1.setLayer(obstacle2, 1);
		obstacle2.setIcon(new ImageIcon(App.class.getResource("/sprites/obstacle.png")));
		obstacle2.setBounds(Integer.valueOf(obstacle2X), Integer.valueOf(obstacle2Y), 60, 60);
		layeredPane_1.add(obstacle2);
		
		JLabel obstacle3 = new JLabel("");
		layeredPane_1.setLayer(obstacle3, 1);
		obstacle3.setIcon(new ImageIcon(App.class.getResource("/sprites/obstacle.png")));
		obstacle3.setBounds(Integer.valueOf(obstacle3X), Integer.valueOf(obstacle3Y), 60, 60);
		layeredPane_1.add(obstacle3);
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("Go".equals(e.getActionCommand())) {
					if (playing) {
						Instruction currentInstruction = instructionQueue.peek();
						
						if (currentInstruction.direction == 3 || currentInstruction.direction == 4) {
							player.setIcon(new ImageIcon(App.class.getResource("/sprites/marsrobot2.png")));
						}else {
							player.setIcon(new ImageIcon(App.class.getResource("/sprites/marsrobot.png")));
						}
						if (currentInstruction.direction == 1) {
							player.setBounds(player.getBounds().x, player.getBounds().y - currentInstruction.distance*30, 60, 60);
						}
						if (currentInstruction.direction == 2) {
							player.setBounds(player.getBounds().x, player.getBounds().y + currentInstruction.distance*30, 60, 60);
						}
						if (currentInstruction.direction == 3) {
							player.setBounds(player.getBounds().x - currentInstruction.distance*30, player.getBounds().y, 60, 60);
						}
						if (currentInstruction.direction == 4) {
							player.setBounds(player.getBounds().x + currentInstruction.distance*30, player.getBounds().y, 60, 60);
						}
							
						if (testCollision(player, science)) {
							science.setVisible(false);
							lblYouWin.setVisible(true);
							playing = false;
						}
						
						if (testCollision(player, obstacle1)) {
							obstacle1.setVisible(false);
							lblYouLose.setVisible(true);
							playing = false;
						}
						if (testCollision(player, obstacle2)) {
							obstacle2.setVisible(false);
							lblYouLose.setVisible(true);
							playing = false;
						}
						if (testCollision(player, obstacle3)) {
							obstacle3.setVisible(false);
							lblYouLose.setVisible(true);
							playing = false;
						}
						
						
						panel.remove(instructionLabelQueue.peek());
						panel.updateUI();
						instructionLabelQueue.remove();
						instructionQueue.remove();
					}
				}
			}
		});
	}
	 
	public Boolean testCollision(JLabel player, JLabel other) {
		Boolean onXAxis;
		Boolean onYAxis;
		if (player.getBounds().x < (other.getBounds().x + other.getBounds().width) && player.getBounds().x > (other.getBounds().x - other.getBounds().width)) {
			onXAxis = true;
		}else {
			onXAxis = false;
		}
		if (player.getBounds().y < (other.getBounds().y + other.getBounds().height) && player.getBounds().y > (other.getBounds().y - other.getBounds().height)) {
			onYAxis = true;
		}else {
			onYAxis = false;
		}
		
		if (onXAxis && onYAxis) {
			return true;
		}else {
			return false;
		}
	}
	
	public void paint(Graphics g) {
		g.drawOval(1, 2, 3, 4);
	}
}
