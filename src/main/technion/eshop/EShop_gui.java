package technion.eshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class EShop_gui {

	private JFrame frame;
	private JTextField textField;
	private JButton btnCalculate;
	
	private static Integer i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EShop_gui window = new EShop_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EShop_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(129, 93, 142, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textField.setText(i.toString());
		
		btnCalculate = new JButton("click me");
		
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("siham");
				i++;
				
				textField.setText(i.toString());
				if(i > 5)
					btnCalculate.setEnabled(false);
					
				//textField.setText("siham");
			}
		});
		btnCalculate.setBounds(10, 49, 89, 23);
		frame.getContentPane().add(btnCalculate);
		
		JLabel lblNumberOfClicks = new JLabel("number of clicks");
		lblNumberOfClicks.setBounds(132, 48, 100, 25);
		frame.getContentPane().add(lblNumberOfClicks);
	}
}
