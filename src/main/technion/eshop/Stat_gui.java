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
import technion.eshop.entities.Report;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Stat_gui {

	private Report myReport;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JComboBox<Product> comboBoxDay;
	private JComboBox<Product> comboBoxHour;
	private JComboBox<Product> comboBoxProduct;

	private DefaultComboBoxModel<Product> modelDay;
	private DefaultComboBoxModel<Product> modelHour;
	private DefaultComboBoxModel<Product> modelProduct;

	/**
	 * Launch the application.
	 */
	public void main6(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stat_gui window = new Stat_gui(myReport);
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
	public Stat_gui(Report r) {
		myReport = r;
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

		JLabel lblEshopStatistics = new JLabel("EShop Statistics");
		lblEshopStatistics.setBounds(26, 11, 110, 22);
		frame.getContentPane().add(lblEshopStatistics);

		JLabel lblCustometsInDay = new JLabel("customers in day");
		lblCustometsInDay.setBounds(26, 61, 129, 14);
		frame.getContentPane().add(lblCustometsInDay);

		JLabel lblCustomersInHour = new JLabel("customers in hour today");
		lblCustomersInHour.setBounds(26, 97, 135, 14);
		frame.getContentPane().add(lblCustomersInHour);

		comboBoxDay = new JComboBox();
		comboBoxDay.setBounds(188, 61, 129, 21);
		frame.getContentPane().add(comboBoxDay);
		modelDay = new javax.swing.DefaultComboBoxModel(myReport.getDays()
				.toArray());
		comboBoxDay.setModel(modelDay);

		textField = new JTextField();
		textField.setBounds(347, 62, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		comboBoxHour = new JComboBox();
		comboBoxHour.setBounds(188, 97, 129, 22);
		frame.getContentPane().add(comboBoxHour);
		modelHour = new javax.swing.DefaultComboBoxModel(myReport.getHours()
				.toArray());
		comboBoxHour.setModel(modelHour);

		textField_1 = new JTextField();
		textField_1.setBounds(347, 98, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNumberOfSales = new JLabel("number of sales by product");
		lblNumberOfSales.setBounds(26, 160, 154, 14);
		frame.getContentPane().add(lblNumberOfSales);

		textField_2 = new JTextField();
		textField_2.setBounds(347, 157, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		comboBoxProduct = new JComboBox();
		comboBoxProduct.setBounds(188, 157, 129, 22);
		frame.getContentPane().add(comboBoxProduct);
		modelProduct = new javax.swing.DefaultComboBoxModel(myReport
				.getProducts().toArray());
		comboBoxProduct.setModel(modelProduct);

	}
}
