package technion.eshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EShop2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EShop2 window = new EShop2();
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
	public EShop2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel home = new JPanel();
		frame.getContentPane().add(home, "name_644152567833587");
		home.setLayout(null);
		
		JButton btnScreen = new JButton("screen 1");
		btnScreen.setBounds(107, 92, 89, 23);
		home.add(btnScreen);
		
		JButton btnScreen_1 = new JButton("screen 2");
		btnScreen_1.setBounds(244, 92, 89, 23);
		home.add(btnScreen_1);
		
		JPanel screen1 = new JPanel();
		frame.getContentPane().add(screen1, "name_644155787843339");
		screen1.setLayout(null);
		
		JLabel lblScreen = new JLabel("screen 1");
		lblScreen.setBounds(42, 27, 41, 14);
		screen1.add(lblScreen);
		
		JPanel screen2 = new JPanel();
		frame.getContentPane().add(screen2, "name_644164360398114");
		screen2.setLayout(null);
		
		JLabel lblScreen_1 = new JLabel("screen 2");
		lblScreen_1.setBounds(196, 5, 41, 14);
		screen2.add(lblScreen_1);
	}
}
