package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class initiate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initiate frame = new initiate();
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
	public initiate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setForeground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(0, 0, 463, 85);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Initiated");
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		
		JLabel lblNewLabel_1 = new JLabel("The automatic elevator system  has been initiated. Fill in the details to initiate");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Number of persons");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 95, 120, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weight");
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 122, 45, 17);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(140, 96, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 122, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Door Status");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(263, 98, 71, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Floor number");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(263, 125, 82, 13);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(354, 95, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(354, 122, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Emergency Floor Request");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 20, 147));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(24, 282, 177, 21);
		contentPane.add(btnNewButton);
		
		JButton btnGenerateFloorRequest = new JButton("Generate Floor Request");
		btnGenerateFloorRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateFloorRequest.setForeground(Color.BLACK);
		btnGenerateFloorRequest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerateFloorRequest.setBackground(new Color(255, 20, 147));
		btnGenerateFloorRequest.setBounds(24, 251, 177, 21);
		contentPane.add(btnGenerateFloorRequest);
		
		JButton btnNewButton_2 = new JButton("Overall Status");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBackground(new Color(255, 20, 147));
		btnNewButton_2.setBounds(178, 151, 129, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Power Cut");
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1.setBackground(new Color(255, 20, 147));
		btnNewButton_2_1.setBounds(321, 266, 129, 21);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_6 = new JLabel("Person Entering");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(40, 195, 113, 18);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Person Exiting");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setBounds(340, 195, 123, 18);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Lift moving");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_2.setForeground(Color.WHITE);
		lblNewLabel_6_2.setBounds(40, 223, 113, 18);
		contentPane.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Emergency Call");
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_2_1.setForeground(Color.WHITE);
		lblNewLabel_6_2_1.setBounds(188, 214, 131, 27);
		contentPane.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_6_2_2 = new JLabel("Weight Overload");
		lblNewLabel_6_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_2_2.setForeground(Color.WHITE);
		lblNewLabel_6_2_2.setBounds(340, 223, 123, 18);
		contentPane.add(lblNewLabel_6_2_2);
	}
}
