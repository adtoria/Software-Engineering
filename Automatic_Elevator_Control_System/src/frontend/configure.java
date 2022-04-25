package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class configure extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	boolean weight_valid;
	boolean email_valid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configure frame = new configure();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public configure() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel weight_print = new JLabel("Not a value");
		weight_print.setBounds(295, 155, 98, 13);
		contentPane.add(weight_print);
		weight_print.setVisible(false);

		JLabel mail_print = new JLabel("New label");
		mail_print.setBounds(403, 171, 46, 13);
		contentPane.add(mail_print);
		mail_print.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 463, 47);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("CONFIGURE");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(0, 42, 436, 29);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Set the threshold values for number of people and weight");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Maximum number of people");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(38, 99, 195, 22);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Maximum Weight (in Kg)");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(38, 130, 195, 22);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Set Admin Mail ID");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(38, 164, 195, 22);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Update Emergency IDs");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(38, 196, 195, 22);
		contentPane.add(lblNewLabel_2_1_1_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
		comboBox.setBounds(295, 108, 98, 21);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				weight_print.setVisible(false);
				if (Pattern.matches("[0-9]{1,13}(\\.[0-9]*)?", s) == true) {
					Double w = Double.parseDouble(s);
					if (w < 400 || w > 1100) {
						weight_print.setVisible(true);
						weight_valid = false;
						weight_print.setText("Value should be between 400 and 1100");
					} else {
						weight_valid = true;
						weight_print.setVisible(false);
						weight_print.setText("Valid");
					}
				} else {
					weight_print.setText("Not a value");
					weight_print.setVisible(true);
					weight_valid = false;
				}

			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(295, 139, 98, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField_1.getText();

				boolean res = s.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
				if (res == true) {
					mail_print.setText("Valid Mail id");
					mail_print.setVisible(true);
					email_valid = true;
				} else {
					mail_print.setText("Not a valid Mail id");
					mail_print.setVisible(true);
					email_valid = false;

				}

			}
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(295, 168, 98, 19);
		contentPane.add(textField_1);

		JButton updateButton = new JButton("Update");
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weight_valid == false || email_valid == false) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Wrong Input!!!");
					mainpage.set_val(false);
					return;
				}

				String s = (String) comboBox.getSelectedItem();
				int maxi = Integer.parseInt(s);
				classes.main.set_person(maxi);

				s = (String) textField.getText();
				Double w = Double.parseDouble(s);
				classes.main.set_weight(w);

				s = textField_1.getText();
				classes.main.set_mail(s);

				JFrame f;
				f = new JFrame();
				JOptionPane.showMessageDialog(f, "Successfully Updated!");
				mainpage.set_val(true);

			}
		});
		updateButton.setBounds(178, 232, 85, 21);
		contentPane.add(updateButton);

		JButton editButton = new JButton("Edit Here");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emergency_id eid = new emergency_id();
				eid.main(null);
			}
		});
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editButton.setBounds(295, 199, 98, 21);
		contentPane.add(editButton);

	}
}
