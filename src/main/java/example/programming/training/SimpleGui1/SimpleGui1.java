package example.programming.training.SimpleGui1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui1 {
	
	JFrame frame;
	JLabel label;
	JButton button;
	
	int x = 70;
	int y = 70;
	
	public static void main (String[] args) {
		SimpleGui1 gui = new SimpleGui1();
		gui.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change colors");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("Label");
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		for (int i = 0; i < 130; i++) {
			x++;
			y++;
			drawPanel.repaint();
			try {
				Thread.sleep(50);
			}
			catch (Exception ex) {}
		}
	}
	
	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			
			Color randomColor = new Color(red,green,blue);
			g.setColor(randomColor);
			g.fillOval(x, y, 40, 40);
		}
	}
	
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("Pushed!");
		}
	}
	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
}