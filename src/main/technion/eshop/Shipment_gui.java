package technion.eshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import technion.eshop.entities.Box;
import technion.eshop.entities.Cart;
import technion.eshop.entities.Product;
import technion.eshop.entities.Shipment;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class Shipment_gui {

	private JFrame frame;
	private JTextField textField;

	private JComboBox<Product> comboBoxProduct;
	private DefaultComboBoxModel<Product> modelProduct;

	private JComboBox<Box> comboBoxBox;
	private DefaultComboBoxModel<Box> modelBox;

	private Cart currCart;
	private Shipment currShipment;

	private JButton btnAddToBox;
	private JButton btnSend;

	private JTextArea textArea;
	private JLabel lblInsertAddress;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void main3(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shipment_gui window = new Shipment_gui(currCart);

					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param currCart
	 */
	public Shipment_gui(Cart newCart) {
		currCart = newCart;
		currShipment = new Shipment(newCart);
		// this.model = model;
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

		btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO send to ExitGUI ?
				System.out.println("thank you for using ESHop");
			}
		});
		btnSend.setBounds(303, 286, 121, 37);
		// TODO disable button !!!
		btnSend.enableInputMethods(false);
		frame.getContentPane().add(btnSend);

		JLabel label = new JLabel("insert your name:");
		label.setBounds(31, 34, 129, 14);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(126, 31, 86, 20);
		frame.getContentPane().add(textField);

		JLabel lblAddProductsTo = new JLabel("add products to boxes");
		lblAddProductsTo.setBounds(31, 88, 108, 14);
		frame.getContentPane().add(lblAddProductsTo);

		comboBoxProduct = new JComboBox<Product>();
		modelProduct = new javax.swing.DefaultComboBoxModel(currCart
				.getProductsInCart().toArray());
		comboBoxProduct.setModel(modelProduct);
		comboBoxProduct.setBounds(172, 85, 284, 20);
		frame.getContentPane().add(comboBoxProduct);

		btnAddToBox = new JButton("add to box");
		btnAddToBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				Product p = (Product) comboBoxProduct.getSelectedItem();
				comboBoxProduct.removeItem(p);
				currShipment.addProductToBox(p);

				modelBox = new javax.swing.DefaultComboBoxModel(currShipment
						.getBoxes().toArray());
				comboBoxBox.setModel(modelBox);

				if (currShipment.getProductsNum() == currCart
						.getProductsInCart().size()) {
					System.out.println("now to sending");
					// visible
					// textField_1.setEnabled(true);
					textField_1.setVisible(true);
					lblInsertAddress.setVisible(true);

					currShipment.setAddress(textField_1.getText());
					System.out.println("the address is" + textField_1.getText());

				}

				// model.addElement(p);//??
				// stockProducts.setModel(model);
			}
		});
		btnAddToBox.setBounds(335, 116, 121, 23);
		frame.getContentPane().add(btnAddToBox);

		JLabel lblYourBoxes = new JLabel("your boxes");
		lblYourBoxes.setBounds(31, 155, 75, 50);
		frame.getContentPane().add(lblYourBoxes);

		comboBoxBox = new JComboBox<Box>();
		comboBoxBox.setBounds(126, 170, 89, 20);
		frame.getContentPane().add(comboBoxBox);

		textArea = new JTextArea(5, 20);
		textArea.setBounds(252, 170, 204, 90);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		// TODO the box is not selected !!
		Box b = (Box) comboBoxBox.getSelectedItem();
		if (b == null) {
			System.out.println("the box is null !!!");
			textArea.setText("");
		} else
			textArea.setText(b.toString());

		JButton btnInitShipmentStation = new JButton("init shipment station");
		btnInitShipmentStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddToBox.setEnabled(true);
				btnSend.setEnabled(true);
			}
		});
		btnInitShipmentStation.setBounds(242, 30, 135, 23);
		frame.getContentPane().add(btnInitShipmentStation);

		btnAddToBox.setEnabled(false);
		btnSend.setEnabled(false);

		lblInsertAddress = new JLabel("Insert address");
		lblInsertAddress.setBounds(31, 272, 86, 14);
		frame.getContentPane().add(lblInsertAddress);
		lblInsertAddress.setVisible(false);

		textField_1 = new JTextField();
		// textField_1.setEnabled(false);
		textField_1.setVisible(false);
		textField_1.setBounds(126, 269, 135, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

	}

}
