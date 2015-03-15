package technion.eshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import technion.eshop.entities.Cart;
import technion.eshop.entities.Product;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class ShipmentStat_gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main5(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipmentStat_gui window = new ShipmentStat_gui();
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
	public ShipmentStat_gui() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}
}
