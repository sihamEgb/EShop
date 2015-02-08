package technion.eshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import technion.eshop.entities.Cart;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import technion.eshop.entities.Product;

public class Cart_gui {

	private JFrame frame;
	private static JLabel label_1;
	private JButton btnCheckout;
	private JButton btnShipmentStation;
	private JLabel lblProductsInStock;
	private JComboBox<Product> stockProducts;
	private JButton btnAddToCart;
	private JLabel lblProductsInCart;
	private JComboBox<Product> cartProducts;
	private JButton btnRemoveFromCart;
	private JLabel lblTotal;
	
	private static Cart currCart;

	/**
	 * Launch the application.
	 */
	public static void main2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart_gui window = new Cart_gui(currCart);
					window.frame.setVisible(true);
					label_1.setText(currCart.getCustomerName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cart_gui(Cart newCart) {
		currCart = newCart;
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

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(10, 11, 87, 14);
		frame.getContentPane().add(lblWelcome);

		label_1 = new JLabel("");
		label_1.setBounds(85, 11, 46, 14);
		frame.getContentPane().add(label_1);

		btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(305, 215, 89, 23);
		frame.getContentPane().add(btnCheckout);

		btnShipmentStation = new JButton("Shipment Station");
		btnShipmentStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Shipment_gui myGUI = new Shipment_gui();
				Shipment_gui.main3(null);
				frame.setVisible(false);

			}
		});
		btnShipmentStation.setBounds(130, 215, 152, 23);
		frame.getContentPane().add(btnShipmentStation);

		lblProductsInStock = new JLabel("products in stock");
		lblProductsInStock.setBounds(20, 36, 108, 14);
		frame.getContentPane().add(lblProductsInStock);

		stockProducts = new JComboBox<Product>();
		stockProducts.setBounds(139, 33, 285, 20);
		initProducts();

		frame.getContentPane().add(stockProducts);

		btnAddToCart = new JButton("add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p = (Product) stockProducts.getSelectedItem();
				stockProducts.removeItem(p);
				cartProducts.addItem(p);
				currCart.addProduct(p);
				lblTotal.setText("total: "+currCart.getSum());
				
			}
		});
		btnAddToCart.setBounds(316, 64, 108, 23);
		frame.getContentPane().add(btnAddToCart);

		lblProductsInCart = new JLabel("products in cart");
		lblProductsInCart.setBounds(23, 84, 108, 14);
		frame.getContentPane().add(lblProductsInCart);

		cartProducts = new JComboBox<Product>();
		cartProducts.setBounds(139, 92, 285, 20);
		frame.getContentPane().add(cartProducts);

		btnRemoveFromCart = new JButton("remove from cart");
		btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p = (Product) cartProducts.getSelectedItem();
				cartProducts.removeItem(p);
				stockProducts.addItem(p);
				currCart.removeProduct(p);
				lblTotal.setText("total: "+currCart.getSum());
			}
		});
		btnRemoveFromCart.setBounds(316, 123, 108, 23);
		frame.getContentPane().add(btnRemoveFromCart);

		lblTotal = new JLabel("total:");
		lblTotal.setBounds(20, 168, 77, 14);
		lblTotal.setText("total: "+currCart.getSum());
		frame.getContentPane().add(lblTotal);

	}

	private void initProducts() {

		Product p1 = new Product("milk 1", 10, 4, 10, 2015);
		Product p2 = new Product("milk 2", 10, 4, 10, 2015);
		Product p3 = new Product("milk 3", 10, 4, 10, 2015);

		stockProducts.addItem(p1);
		stockProducts.addItem(p2);
		stockProducts.addItem(p3);

	}
}
