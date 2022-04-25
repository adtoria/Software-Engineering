package frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.controller;

public class emergency_id extends JFrame {

	private JPanel contentPane;
	private JTextField add_text;
	private JTextField subtract_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emergency_id frame = new emergency_id();
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
	public emergency_id() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 508, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		add_text = new JTextField();
		add_text.setBounds(10, 25, 369, 36);
		contentPane.add(add_text);
		add_text.setColumns(10);

		subtract_text = new JTextField();
		subtract_text.setColumns(10);
		subtract_text.setBounds(10, 97, 369, 144);
		contentPane.add(subtract_text);

		List<String> em_id = new ArrayList();

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = add_text.getText();
				add_text.setText("");
				if (s.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Enter a valid id!!!");
				} else {
					boolean check = false;
					if (em_id.indexOf(s) != -1) {
						check = true;
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Entered id, Already Exists!!!");
					} else {
						em_id.add(s);
						classes.controller.add_id(s);
					}

				}
			}
		});
		add.setBounds(399, 32, 85, 21);
		contentPane.add(add);

		JButton subtract = new JButton("Subtract");
		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = em_id.indexOf(subtract_text.getText());
				subtract_text.setText("");
				if (index == -1) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Enter a valid id!!!");
				} else {
					em_id.remove(index);
					controller.remove_id(index);
				}
			}
		});
		subtract.setBounds(399, 97, 85, 21);
		contentPane.add(subtract);
	}
}
