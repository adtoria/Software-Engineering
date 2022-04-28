package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class mainpage extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	static boolean mail_check = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage frame = new mainpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void set_val(boolean val) {
		mail_check = val;
	}

	/**
	 * Create the frame.
	 */
	public mainpage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 204, 356);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("AUTOMATIC");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 30));

		JLabel lblNewLabel_2 = new JLabel("ELEVATOR");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("SYSTEM");
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.add(lblNewLabel);

		JButton configure = new JButton("Configure");
		configure.setForeground(new Color(255, 255, 255));
		configure.setBackground(new Color(0, 0, 128));
		configure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configure btn1 = new configure();
				btn1.main(null);
			}
		});
		configure.setFont(new Font("Rockwell", Font.PLAIN, 20));
		configure.setBounds(258, 43, 154, 33);
		contentPane.add(configure);

		JButton initiate = new JButton("Initiate");
		initiate.setForeground(new Color(255, 255, 255));
		initiate.setBackground(new Color(0, 0, 128));
		initiate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (mail_check == true) {
					initiate btn1 = new initiate();
					// btn1.main(null);
				} else {
					javax.swing.JOptionPane.showMessageDialog(initiate, "Set valid admin Email ID in Configure");
				}
			}
		});
		initiate.setFont(new Font("Rockwell", Font.PLAIN, 20));
		initiate.setBounds(258, 117, 154, 33);
		contentPane.add(initiate);

		JButton report = new JButton("Log Report");
		report.setForeground(new Color(255, 255, 255));
		report.setBackground(new Color(0, 0, 128));
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log btn1 = new log();
				// btn1.main(null);
			}
		});
		report.setFont(new Font("Rockwell", Font.PLAIN, 20));
		report.setBounds(258, 191, 154, 33);
		contentPane.add(report);

	}
}
