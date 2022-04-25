package classes;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javazoom.jl.player.Player;

public class emergencycall extends Thread {
	// mails and related stuff

	protected String mail = main.get_mail();
	protected String sub = "POWER BACKUP NEEDED";
	protected String sos;

	public void run() {
		JFrame f;
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Power Backup Needed");
		alert1();
	}

	public void alert1() {
		InputStream musicInputStream;
		try {
			FileInputStream fileInputStream = new FileInputStream("src/audio.mp3");
			Player player = new Player(fileInputStream);
			player.play();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

}