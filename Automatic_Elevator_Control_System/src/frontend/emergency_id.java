package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 508, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		add_text = new JTextField();
		add_text.setBounds(10, 25, 369, 98);
		contentPane.add(add_text);
		add_text.setColumns(10);

		subtract_text = new JTextField();
		subtract_text.setColumns(10);
		subtract_text.setBounds(10, 143, 369, 98);
		contentPane.add(subtract_text);

		List<String> em_id = new ArrayList();

		JButton add = new JButton("+");
		add.setBackground(new Color(152, 251, 152));
		add.setFont(new Font("Rockwell", Font.PLAIN, 23));
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
		add.setBounds(418, 52, 50, 50);
		contentPane.add(add);

		JButton subtract = new JButton("-");
		subtract.setBackground(new Color(220, 20, 60));
		subtract.setFont(new Font("Rockwell", Font.PLAIN, 23));
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
		subtract.setBounds(418, 161, 50, 50);
		contentPane.add(subtract);
	}
}
