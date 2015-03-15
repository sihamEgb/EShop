package technion.eshop;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JLabel;

import technion.eshop.entities.Cart;
import technion.eshop.entities.Product;
import technion.eshop.entities.Store;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPanel;

import com.google.gson.Gson;

public class EShop_gui {

	private JFrame frame;
	private JButton btnCalculate;

	private static Integer i = 0;
	private JTextField txtName;
	private DefaultComboBoxModel model;

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
		frame.setBounds(10, 10, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnCalculate = new JButton("init cart");
		final Store myStore = new Store();
		model = new javax.swing.DefaultComboBoxModel(myStore.getProducts()
				.toArray());

		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = txtName.getText();
				try {
					Cart newCart = myStore.addCart(name);
					if (newCart == null) {
						// TODO - write a message on window
						System.out.println("choose another name please");
					} else {
						Cart_gui myGUI = new Cart_gui(newCart, model);
						myGUI.main2(null);
						// frame.setVisible(false);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnCalculate.setBounds(156, 118, 89, 23);
		frame.getContentPane().add(btnCalculate);

		txtName = new JTextField();
		txtName.setBounds(156, 74, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblInsertYourName = new JLabel("insert your name:");
		lblInsertYourName.setBounds(20, 77, 129, 14);
		frame.getContentPane().add(lblInsertYourName);

		JLabel lblWelcomeToEshop = new JLabel("Welcome to EShop");
		lblWelcomeToEshop.setBounds(162, 11, 135, 14);
		frame.getContentPane().add(lblWelcomeToEshop);

		JButton btnNewButton = new JButton("Statistics");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stat_gui statGUI = new Stat_gui();
				statGUI.main6(null);
			}
		});
		btnNewButton.setBounds(20, 288, 108, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblForOwnersOnly = new JLabel("For Owners Only");
		lblForOwnersOnly.setBounds(20, 241, 129, 14);
		frame.getContentPane().add(lblForOwnersOnly);

		JButton btnShipmentStationStat = new JButton("Shipment station stat.");
		btnShipmentStationStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShipmentStat_gui shipmentStatGUI = new ShipmentStat_gui(myStore.getReport());
				shipmentStatGUI.main5(null);
			}
		});
		btnShipmentStationStat.setBounds(172, 288, 168, 23);
		frame.getContentPane().add(btnShipmentStationStat);

	}
}
