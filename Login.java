import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
	JButton[] numberButtons = new JButton[10];
	JButton delButton, clrButton, entButton;
	JTextField textfield;
	JFrame frame;
	JPanel panel;
	JLabel header,loginsuccessornot;
	Font myfont = new Font("Arial", Font.BOLD, 30);
	
	int firstPIN = 122122; //BEN DOVER'S PIN
	int secondPIN = 242424; // HENRIK AHNBERG'S PIN
	int thirdPIN = 264264; // SVEN BLACKSMITH'S PIN
	int fourthPIN = 400400; // KYLE ASHNER'S PIN
	int fifthPIN = 445566; // PRECIOUS AYLAR'S PIN
	
	static double firstbalance = 5000; // BEN DOVER'S BALANCE
	static double secondbalance = 12000; // HENRIK AHNBERG'S PIN
	static double thirdbalance = 3000; // SVEN BLACKSMITH'S PIN
	static double fourthbalance = 10000; // KYLE ASHNER'S PIN
	static double fifthbalance = 6000; // PRECIOUS AYLAR'S PIN
	
	Login(){
		frame = new JFrame("Login Pin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(425, 700);
		frame.setLayout(null);
		
		header = new JLabel("Enter PIN");
		header.setBounds(125,25,300,75);
		header.setFont(myfont);

		textfield = new JTextField();
		textfield.setBounds(50, 100, 300, 75);
		textfield.setFont(myfont);
		textfield.setEditable(false);
		
		for(int i = 0; i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myfont);
			numberButtons[i].setFocusable(false);
		}
		delButton = new JButton("Del");
		delButton.addActionListener(this);
		delButton.setFont(myfont);
		delButton.setFocusable(false);
		
		clrButton = new JButton("Clear");
		clrButton.addActionListener(this);
		clrButton.setFont(myfont);
		clrButton.setFocusable(false);
		
		entButton = new JButton("Enter");
		entButton.setBounds(125,530,145,50);
		entButton.addActionListener(this);
		entButton.setFont(myfont);
		entButton.setFocusable(false);
		
		loginsuccessornot = new JLabel("");
		loginsuccessornot.setBounds(150,600,145,50);

		panel = new JPanel();
		panel.setBounds(50, 200, 300, 300);
		panel.setLayout(new GridLayout(4,3,10,10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(numberButtons[0]);
		panel.add(delButton);
		panel.add(clrButton);
		
		frame.add(entButton);
		frame.add(panel);
		frame.setVisible(true);
		frame.add(textfield);
		frame.add(header);
		frame.add(loginsuccessornot);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String firststrPIN = Integer.toString(firstPIN);
		String secondstrPIN = Integer.toString(secondPIN);
		String thirdstrPIN = Integer.toString(thirdPIN);
		String fourthstrPIN = Integer.toString(fourthPIN);
		String fifthstrPIN = Integer.toString(fifthPIN);
		String enteredInput = textfield.getText();
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		/////
		if(e.getSource() == entButton) {
			if(firststrPIN.equals(enteredInput)) {
				loginsuccessornot.setText("Login Successful!");
				firstATM ATM = new firstATM();
				frame.dispose();
			}
			if(secondstrPIN.equals(enteredInput)) {
				loginsuccessornot.setText("Login Successful!");
				secondATM ATM = new secondATM();
				frame.dispose();
			}
			if(thirdstrPIN.equals(enteredInput)) {
				loginsuccessornot.setText("Login Successful!");
				thirdATM ATM = new thirdATM();
				frame.dispose();
			}
			if(fourthstrPIN.equals(enteredInput)) {
				loginsuccessornot.setText("Login Successful!");
				fourthATM ATM = new fourthATM();
				frame.dispose();
			}
			if(fifthstrPIN.equals(enteredInput)) {
				loginsuccessornot.setText("Login Successful!");
				fifthATM ATM = new fifthATM();
				frame.dispose();
			}
			else {
				loginsuccessornot.setText("PIN is Incorrect");
			}
		}
		/////
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++){
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}

	}
	
	public static void main(String[] args) {
		new Login();
		//Made by Marcelee
	}
}
