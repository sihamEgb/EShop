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

public class Exit_gui {

	private JFrame frame;

	private Cart myCart;
	private JLabel lblTheBillIs;
	private JTextArea textArea;
	private final static String newline = "\n";

	/**
	 * Launch the application.
	 */
	public void main4(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exit_gui window = new Exit_gui(myCart);
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
	public Exit_gui(Cart myCart) {
		this.myCart = myCart;
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

		JLabel lblAddProductsTo = new JLabel("Thank you for buying in EShop");
		lblAddProductsTo.setBounds(25, 26, 286, 14);
		frame.getContentPane().add(lblAddProductsTo);

		lblTheBillIs = new JLabel("the bill is:");
		lblTheBillIs.setBounds(25, 136, 76, 14);
		frame.getContentPane().add(lblTheBillIs);

		textArea = new JTextArea(5, 20);
		// JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setBounds(81, 136, 359, 150);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);

		JButton btnSend = new JButton("Bill");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// System.out.println("the bill is:"+myCart.getSum());
				textArea.setText(myCart.getSum().toString());
				// lblTheBillIs.setText(myCart.getSum().toString());
			}
		});
		btnSend.setBounds(81, 65, 89, 23);
		// TODO disable button !!!
		btnSend.enableInputMethods(false);
		frame.getContentPane().add(btnSend);

		JButton btnDetailedBill = new JButton("Detailed Bill");
		btnDetailedBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for (Product p : myCart.getProductsInCart())

					textArea.append(p.toString() + newline);
				// System.out.println("You bought:" + p);
			}
		});
		btnDetailedBill.setBounds(196, 65, 89, 23);
		frame.getContentPane().add(btnDetailedBill);

		JLabel lblPrint = new JLabel("Print: ");
		lblPrint.setBounds(25, 69, 46, 14);
		frame.getContentPane().add(lblPrint);

	}
}
