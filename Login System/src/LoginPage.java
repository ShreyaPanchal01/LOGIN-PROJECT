import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPassField = new JPasswordField();
	JLabel userIDLabel = new JLabel("UserID:");
	JLabel userPassLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	
	public LoginPage(HashMap<String, String> loginInfoOriginal) {
		
		loginInfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPassLabel.setBounds(50,150,75,25);
		
		 messageLabel.setBounds(125,250,250,35);
		 messageLabel.setFont(new Font(null,Font.ITALIC,25));
		 
		 userIDField.setBounds(125,100,200,25);
		 userPassField.setBounds(125,150,200,25);
		 
		 loginButton.setBounds(125,200,100,25);
		 loginButton.setFocusable(false);
		 loginButton.addActionListener(this);
		 
		 resetButton.setBounds(225,200,100,25);
		 resetButton.setFocusable(false);
		 resetButton.addActionListener(this);
		 
		 
		frame.add(userIDLabel);
		frame.add(userPassLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPassField);
		frame.add(loginButton);
		frame.add(resetButton);
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPassField.setText("");
			
		}
		if(e.getSource()==loginButton) {
			String userID = userIDField.getText();
			String pass= String.valueOf(userPassField.getPassword());
			
			if(loginInfo.containsKey(userID)) {
				
				if(loginInfo.get(userID).equals(pass)){
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login Successful");
					WelcomePage welcomePage = new WelcomePage(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password!");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("User not found!");
			}
		}
		
	}

}
