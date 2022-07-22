import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class firstATM extends JFrame implements ActionListener{
	JFrame frame;
	JLabel header,showName,showBalance,showImportant;
	JLabel Information;
	JButton[] numberButtons = new JButton[10];
	JButton decButton,delButton;
	JButton wdrawButton,dpositButton,chgepinButton,refreshButton;
	JButton wiDrawENTButton,dpostENTButton,chgENTButton,cnlButton;
	JPanel panelNumbers, panelFunctions,panelentcnl;
	JTextField textfield;
	Font textfieldFONT = new Font("Arial",Font.BOLD,100);
	firstATM(){
		frame = new JFrame("ATM Machine");
		frame.setSize(850,700);
		
		header = new JLabel("ATM Machine");
		header.setBounds(25,0,100,50);
		showName = new JLabel("Ben Dover");
		showName.setBounds(25,20,100,50);
		
		showImportant = new JLabel("Important notice: Please enter numbers first.");
		showImportant.setBounds(550,0,300,50);
		showBalance = new JLabel("Balance: PHP " + Login.firstbalance);
		showBalance.setBounds(550,20,300,50);
		
		textfield = new JTextField();
		textfield.setBounds(25, 70, 780, 300);
		textfield.setEditable(false);
		textfield.setFont(textfieldFONT);
		
		panelNumbers = new JPanel();
		panelNumbers.setLayout(new GridLayout(4,3,10,10));
		panelNumbers.setBounds(25, 390, 250, 250);
		
		for(int i = 0; i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
		}
		
		decButton = new JButton(".");
		decButton.addActionListener(this);
		decButton.setFocusable(false);
		delButton = new JButton("Del");
		delButton.addActionListener(this);
		delButton.setFocusable(false);
		
		panelNumbers.add(numberButtons[1]);
		panelNumbers.add(numberButtons[2]);
		panelNumbers.add(numberButtons[3]);
		panelNumbers.add(numberButtons[4]);
		panelNumbers.add(numberButtons[5]);
		panelNumbers.add(numberButtons[6]);
		panelNumbers.add(numberButtons[7]);
		panelNumbers.add(numberButtons[8]);
		panelNumbers.add(numberButtons[9]);
		panelNumbers.add(numberButtons[0]);
		panelNumbers.add(decButton);
		panelNumbers.add(delButton);
		
		panelFunctions = new JPanel();
		panelFunctions.setLayout(new GridLayout(4,0,10,10));
		panelFunctions.setBounds(290, 390, 250, 250);
		
		wdrawButton = new JButton("WITHDRAW");
		wdrawButton.addActionListener(this);
		wdrawButton.setFocusable(false);
		dpositButton = new JButton("DEPOSIT");
		dpositButton.addActionListener(this);
		dpositButton.setFocusable(false);
		chgepinButton = new JButton("CHANGE PIN");
		chgepinButton.addActionListener(this);
		chgepinButton.setFocusable(false);
		refreshButton = new JButton("REFRESH");
		refreshButton.addActionListener(this);
		refreshButton.setFocusable(false);
		
		panelFunctions.add(wdrawButton);
		panelFunctions.add(dpositButton);
		panelFunctions.add(chgepinButton);
		panelFunctions.add(refreshButton);
		
		panelentcnl = new JPanel();
		panelentcnl.setLayout(new GridLayout(4,0,10,10));
		panelentcnl.setBounds(555,390,250,250);
		
		wiDrawENTButton = new JButton("ENTER");
		wiDrawENTButton.addActionListener(this);
		wiDrawENTButton.setFocusable(false);
		dpostENTButton = new JButton("ENTER");
		dpostENTButton.addActionListener(this);
		dpostENTButton.setFocusable(false);
		chgENTButton = new JButton("ENTER");
		chgENTButton.addActionListener(this);
		chgENTButton.setFocusable(false);
		cnlButton = new JButton("CLEAR/CANCEL");
		cnlButton.addActionListener(this);
		cnlButton.setFocusable(false);
		
		panelentcnl.add(wiDrawENTButton);
		panelentcnl.add(dpostENTButton);
		panelentcnl.add(chgENTButton);
		panelentcnl.add(cnlButton);
		
		Information = new JLabel("");
		Information.setBounds(35,230,450,185);
		
		frame.add(Information);
		frame.add(header);frame.add(showName);frame.add(showBalance);frame.add(showImportant);
		frame.add(textfield);
		frame.add(panelNumbers);frame.add(panelFunctions);frame.add(panelentcnl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String enteredInput = textfield.getText();
		/* THE NUMBERS */
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++){
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		/* THE FUNCTIONS */
		if(e.getSource()== wdrawButton) {
			Information.setText("<html>Are you sure you want to WITHDRAW: PHP " +
				    enteredInput+ " to your Account? <br>If YES, press ENTER. If NOT, press CANCEL."
				    + "<br>Important Note: ONLY USE the ENTER BUTTON BESIDE the WITHDRAW BUTTON."
				    + "<br>TO AVOID COMPLICATIONS.</html>");
		}
		if(e.getSource()== wiDrawENTButton) {
			double withdrawMoney = Double.parseDouble(enteredInput);
			Login ATM = new Login();
			ATM.firstbalance = ATM.firstbalance - withdrawMoney;
			frame.dispose();
		}
		/////
		if(e.getSource()==dpositButton) {
			Information.setText("<html>Are you sure you want to DEPOSIT: PHP " +
		    enteredInput+ " to your Account? <br>If YES, press ENTER. If NOT, press CANCEL."
		    + "<br>Important Note: ONLY USE the ENTER BUTTON BESIDE the DEPOSIT BUTTON."
		    + "<br>TO AVOID COMPLICATIONS.</html>");
		}
		if(e.getSource() == dpostENTButton) {
			double depositMoney = Double.parseDouble(enteredInput);
			Login ATM = new Login();
			ATM.firstbalance = ATM.firstbalance + depositMoney;
			frame.dispose();
		}
		/////
		if(e.getSource()==chgepinButton) {
			Information.setText("<html>Are you sure you want to CHANGE your PIN to: " +
		    enteredInput+ " <br>If YES, press ENTER. If NOT, press CANCEL. "
		    		+ "<br>Important Note: ONLY USE the ENTER BUTTON BESIDE the CHANGE PIN BUTTON."
				    + "<br>TO AVOID ANY COMPLICATIONS.</html>");
	    }
		if(e.getSource() == chgENTButton) {
			int newPIN = Integer.parseInt(enteredInput);
			Login Login = new Login();
			Login.firstPIN = newPIN;
			frame.dispose();
		}
		/////
		if(e.getSource()== refreshButton) {
			firstATM refresh = new firstATM();
			frame.dispose();
		}
		/////
		if(e.getSource()==cnlButton) {
			textfield.setText("");
		}

	}
	
	public static void main(String[] args) {
		new firstATM();
		//Made by Marcelee
	}

}
