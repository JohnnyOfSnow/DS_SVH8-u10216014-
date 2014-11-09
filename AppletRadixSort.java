import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.*;

public class AppletRadixSort extends JApplet {
	private static JTextField textField;
	JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5343\u4F4D\u6578\r\n",true); // digit in thousands
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u767E\u4F4D\u6578"); // digit in hundrans
	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u5341\u4F4D\u6578"); // digit in tens
	JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u500B\u4F4D\u6578"); // digit in ones
	JButton btnNewButton = new JButton("\u4E0B\u4E00\u6B65"); // Click it can execute the next step
	JButton btnNewButton_1 = new JButton("\u3127\u6B21\u5B8C\u6210Sort"); // Click it can do all radix sort at once.
	JButton btnNewButton_2 = new JButton("\u5168\u90E8\u6E05\u9664"); // Click it can clear all result.
	JButton btnNewButton_3 = new JButton("\u958B\u59CB\u7522\u751F\u4E82\u6578"); // Click it can generate the random number
	static TextArea textArea_1; // Display all operation.
	static TextArea textArea; // Display the random result.
	static JFrame frame;
	static int randomAmount = 10;
	static int randomRange = 10000;
	static int[] originalArray;
	static int[] sortArray;
	static String displayArrayByString = "";

	// In order to run standalone as a standalone application, we add the main method.
	public static void main(String[] args) {
		// Create a frame.
		frame = new JFrame("Radix Sort for integer");
		// Create an instance of the applet.
		AppletRadixSort applet = new AppletRadixSort();
		// Add the applet to the frame.
		frame.add(applet);
		// Display the frame.
		frame.setSize(480,580);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Owing to Applet life-cycle, the method will automatically be invoked.
	public void init(){
		resize(480,580); // Set the applet size, or the window is too small initially.
	}

	/**
	 * Create the applet.
	 */
	public AppletRadixSort() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Radix Sort");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 10, 143, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F4D\u6578\uFF1A");
		lblNewLabel_1.setBounds(10, 45, 66, 27);
		getContentPane().add(lblNewLabel_1);
		
		
		rdbtnNewRadioButton.setBounds(63, 47, 107, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		
		rdbtnNewRadioButton_1.setBounds(184, 47, 107, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		
		rdbtnNewRadioButton_2.setBounds(63, 78, 107, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		
		rdbtnNewRadioButton_3.setBounds(184, 78, 107, 23);
		getContentPane().add(rdbtnNewRadioButton_3);

		ButtonGroup group = new ButtonGroup(); // A button group we use in order to tight two radioButton.
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u6578\u91CF\uFF1A");
		lblNewLabel_2.setBounds(10, 110, 46, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(63, 107, 165, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("10");
		
		JLabel lblNewLabel_3 = new JLabel("\u96A8\u6A5F\u7522\u751F\uFF1A");
		lblNewLabel_3.setBounds(10, 153, 66, 15);
		getContentPane().add(lblNewLabel_3);
		
		
		btnNewButton.setBounds(45, 243, 87, 23);
		getContentPane().add(btnNewButton);
		
		
		btnNewButton_1.setBounds(171, 243, 115, 23);
		getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_2.setBounds(319, 243, 87, 23);
		getContentPane().add(btnNewButton_2);

		
		btnNewButton_3.setBounds(254, 106, 125, 23);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8655\u7406\u904E\u7A0B\uFF1A");
		lblNewLabel_4.setBounds(10, 278, 66, 15);
		getContentPane().add(lblNewLabel_4);
		
		textArea_1 = new TextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 299, 440, 236);
		getContentPane().add(textArea_1);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(79, 153, 371, 73);
		getContentPane().add(textArea);

		btnNewButton.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_1.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_2.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_3.addActionListener(new ButtonListener()); // Register listener.
		rdbtnNewRadioButton.addActionListener(new ButtonListener()); // Register listener.
		rdbtnNewRadioButton_1.addActionListener(new ButtonListener()); // Register listener.
		rdbtnNewRadioButton_2.addActionListener(new ButtonListener()); // Register listener.
		rdbtnNewRadioButton_3.addActionListener(new ButtonListener()); // Register listener.
	}

	static int[] randomGenerateNumber() {
		
		/**
		 *  Create a array to store the random number.
		 *  For loop can generate random number.
		 */
		int[] list = new int[randomAmount];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * randomRange) + 1;
		}

		/**
		 *  Checking the numbers whether are same or not.
		 *  case: have the same number(should random another number)
		 */
		int RepeatCount = 0;
		for (int i = 0; i < list.length; i++) {
			for (int k = 0; k < i; k++) {
				if(list[i] == list[k]){
					list[i] = (int)(Math.random() * randomRange) + 1;
					RepeatCount = RepeatCount + 1;
				}
			}
			if (RepeatCount > 0) {
				RepeatCount = 0;
				i = i - 1;
			}
		}

		return list;
	}

	static String IntegerArrayToString(int[] array){
		StringBuilder op = new StringBuilder();
		for(int i = 0; i < array.length; i++){
			op.append(array[i] + " ");
		}
		String op1 = new String(op);
		return op1;
	}

	// A class is responsible for action presentation.
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnNewButton){
				textArea.setText("next step");
			}else if(e.getSource() == btnNewButton_1){
				textArea.setText("all do");
			}else if(e.getSource() == btnNewButton_2){
				textArea.setText("clear all");
			}else if(e.getSource() == btnNewButton_3){
				String re = textField.getText();
				randomAmount = Integer.parseInt(re);
				if(randomAmount <= 0){
					randomAmount = 10; // Avoiding error amount leads to program terminate.
				}
				originalArray = new int[randomAmount];
				originalArray = randomGenerateNumber();
				displayArrayByString = IntegerArrayToString(originalArray);
				textArea.setText(displayArrayByString);
			}else if(e.getSource() == rdbtnNewRadioButton){
				randomRange = 10000; // digit in thousands
			}else if(e.getSource() == rdbtnNewRadioButton_1){
				randomRange = 1000; // digit in hundrans
			}else if(e.getSource() == rdbtnNewRadioButton_2){
				randomRange = 100; // digit in tens
			}else if(e.getSource() == rdbtnNewRadioButton_3){
				randomRange = 10; // digit in ones
			}else{

			} // end if
		}// end method actionPerformed
	}// end inner class ButtonListener
}
