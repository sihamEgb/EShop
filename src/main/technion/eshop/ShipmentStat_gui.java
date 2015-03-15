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

public class ShipmentStat_gui {

	private JFrame frame;

	private Report myReport;

	private DefaultComboBoxModel<Box> modelBox;
	private JTextArea textArea;
	private JTextArea textArea_1;
	

	/**
	 * Launch the application.
	 */
	public void main5(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipmentStat_gui window = new ShipmentStat_gui(myReport);
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
	public ShipmentStat_gui(Report r) {

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

		JLabel lblShipmentStatistics = new JLabel("Shipment Statistics");
		lblShipmentStatistics.setBounds(37, 11, 164, 28);
		frame.getContentPane().add(lblShipmentStatistics);

		JLabel lblNumberOfShipments = new JLabel("number of shipments");
		lblNumberOfShipments.setBounds(37, 50, 147, 14);
		frame.getContentPane().add(lblNumberOfShipments);
		lblNumberOfShipments.setText("number of boxes "
				+ myReport.getNumberOfBoxes().toString());

		final JComboBox<Box> comboBox = new JComboBox<Box>();
		modelBox = new javax.swing.DefaultComboBoxModel(myReport.getBoxes()
				.toArray());
		comboBox.setModel(modelBox);

		comboBox.setBounds(126, 90, 102, 22);
		frame.getContentPane().add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Box b = (Box) comboBox.getSelectedItem();
				if (b == null) {
					textArea.setText("");
					textArea_1.setText("");
					
				} else
				{
					textArea.setText(b.getBoxContent());
					textArea_1.setText((myReport.getShipmentAddressByBoxId(b.getId())));

				}

			}
		});
		textArea = new JTextArea();
		textArea.setBounds(126, 163, 223, 101);
		frame.getContentPane().add(textArea);

		textArea_1 = new JTextArea();
		textArea_1.setBounds(126, 132, 223, 22);
		frame.getContentPane().add(textArea_1);

		JLabel lblShipmentId = new JLabel("shipment id");
		lblShipmentId.setBounds(37, 89, 116, 24);
		frame.getContentPane().add(lblShipmentId);

	}
}
