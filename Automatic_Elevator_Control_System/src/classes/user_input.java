package classes;

import java.util.*;
import java.util.Random;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author Group8
 */
public class user_input {

	protected Set<Integer> floor_number = new HashSet<>();

	private static final DecimalFormat df = new DecimalFormat("0.00");
	protected int in;
	protected int out;
	protected int floor_count;
	protected static List<Double> w = new ArrayList<Double>();
	protected boolean sos = false;

	public Set<Integer> floor_list() {
		return floor_number;
	}

	public List<Double> weight_list() {
		return w;
	}

	public user_input(int in, int out, boolean sos, int floor_count) {
		this.in = in;
		this.out = out;
		this.floor_count = floor_count;
		this.sos = sos;
		input_controller();
		System.out.println(w);
		System.out.println(floor_number);
	}

	public void input_controller() {
		Random r = new Random();
		int k1 = in;
		int k2 = out;
		while (k2 > 0) {
			k2--;
			w.remove(r.nextInt(w.size()));
		}

		while (k1 > 0) {
			k1--;
			w.add(Double.parseDouble((df.format(60 + 90 * r.nextDouble()))));
		}

		if (in > 0 && sos == false) {
			System.out.println("NO PROBLEM");
			floor_number.add(r.nextInt(floor_count));
		}

		if (in > 0 && sos == true) {
			System.out.println("HELP");
			floor_number.add(r.nextInt(floor_count));
		}

	}

}
