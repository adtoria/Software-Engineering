package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class persons extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					persons frame = new persons();
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
	public persons() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int k1 = 0;
		int k2 = 0;

		JComboBox enter = new JComboBox();
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p1 = -1;
				p1 = Integer.parseInt((String) enter.getSelectedItem());
//				System.out.println(p1);
			}
		});
		enter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enter.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
		enter.setBounds(294, 68, 56, 21);
		contentPane.add(enter);

		JLabel lblNewLabel = new JLabel("Enter Persons Entering / leaving");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(69, 10, 311, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Leaving");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(79, 150, 101, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Entering");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(79, 72, 101, 21);
		contentPane.add(lblNewLabel_1_1);

		JComboBox leave = new JComboBox();
		leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p2 = -1;
				p2 = Integer.parseInt((String) leave.getSelectedItem());
				// System.out.println(p2);
			}
		});
		leave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leave.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
		leave.setBounds(294, 153, 56, 21);
		contentPane.add(leave);

//		System.out.println(k1);
//		System.out.println(k2);
	}
}
