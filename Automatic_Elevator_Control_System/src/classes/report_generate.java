package classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Group8
 */
public class report_generate {

	LocalDateTime time;
	String formatter;
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
	// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	File f = new File("src/report.txt");
	FileWriter mywriter;

	public report_generate(int fl, int in, int out, double weight, boolean sos, boolean failure) {
		time = LocalDateTime.now();
		formatter = df.format(time);

		String to_print = formatter + " : \t Floor Number " + fl + " \t Enters " + in + " \t Exits " + out
				+ " \t Weight " + weight;

		if (sos) {
			to_print += "\t EMERGENCY SITUATION";
		}
		to_print += "\n\n";
		System.out.println("Yes");
		try {
			f.createNewFile();
			PrintWriter p = new PrintWriter(new FileOutputStream(f, true));
			p.append(to_print);
			p.close();

		} catch (Exception e) {
			System.out.println("ERROR !!!");
		}

		if (failure) {
			backup(failure);
		}
	}

	private void backup(boolean failure) {
		time = LocalDateTime.now();
		formatter = df.format(time);

		String to_print = "";
		if (failure == false) {
			to_print = formatter + " \t Power Backup Received, Functioning Fine \n\n";
		} else {
			to_print = formatter + " \t Power Cut, Backup Needed \n\n";
		}

		try {
			f.createNewFile();
			PrintWriter p = new PrintWriter(new FileOutputStream(f, true));
			p.append(to_print);
			p.close();

		} catch (Exception e) {
			System.out.println("ERROR BUDDY!!!");
		}
	}
}
