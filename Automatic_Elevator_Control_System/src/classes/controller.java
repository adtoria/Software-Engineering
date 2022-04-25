package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;

/**
 *
 * @author Group8
 */
public class controller extends main {

	public static int val = 0;
	Timer t = new Timer();
	protected static door door_status = door.OPENED;

	protected static int floor_total = 10;
	protected double weight = 0.00;
	protected int persons = 0;

	protected static List<Double> weight_in_elevator = new ArrayList<Double>();
	protected static direction dr = direction.ATHALT;

	protected static boolean coming = false;
	public static int current = 1;

	// treeset to maintain ascending order
	public static TreeSet<Integer> up;
	public static TreeSet<Integer> down;
	public static TreeSet<Integer> temp;

	protected static List<String> id = new ArrayList<String>();
	public static boolean sos = false;

	public controller() {

		int val;
		dr = direction.ATHALT;
		this.up = new TreeSet<>();
		this.temp = new TreeSet<Integer>();
		this.door_status = door.CLOSED;
		this.down = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		t.schedule(movement, 0, 1000);
		this.current = 0;

	}

	public direction get_elevator_direction() {
		return dr;
	}

	public static direction get_Direction() {
		return dr;
	}

	public int get_floor_count() {
		return floor_total;
	}

	public boolean need_help() {
		return sos;
	}

	public static int current_floor() {
		return current;
	}

	public static boolean get_coming() {
		return coming;
	}

	public void incoming(boolean val) {
		coming = val;
	}

	public void direct() {
		if (dr == direction.ATHALT) {
			if (up.size() > 0 && down.size() > 0) {
				if (Math.abs(current - up.first()) < Math.abs(current - down.first())) {
					dr = direction.UP;
					return;
				} else {
					dr = direction.DOWN;
				}
			} else if (up.size() > 0)
				dr = direction.UP;
			else if (down.size() > 0)
				dr = direction.DOWN;
		}
	}

	public boolean checker() {
		direct();

		if (sos == true && up.size() == 0 && down.size() == 0) {
			sos = false;
			System.out.println("ERROR NEED TO SET TO FALSE");
			temp.forEach(a -> {
				add_dest(a);
			});
			temp.clear();
		}

		boolean ans = false;
		if (dr == direction.UP) {
			if (up.first() == current)
				ans = pop_up("up");
			else {
				move_up();
			}
		}
		if (dr == direction.DOWN) {
			if (down.first() == current)
				ans = pop_up("down");
			else {
				move_down();
			}
		}
		return ans;
	}

	public void move_up() {
		current += 1;
	}

	public void move_down() {
		current -= 1;
	}

	public static door door_check() {
		return door_status;
	}

	public Integer person_count() {
		return persons;
	}

	public double weight_check() {
		return weight;
	}

	public void weight_input(double w) {
		this.weight = w;
	}

	public void person_count_check(int in, int out) {
		persons += (in - out);
	}

	public static void remove_id(int ind) {
		id.remove(ind);
	}

	public static void add_id(String s) {
		id.add(s);
	}

	public static List<String> get_sos() {
		return id;
	}

	public int up_dedst() {
		return up.size();
	}

	public int down_dest() {
		return down.size();
	}

	public static void add_temp(int k) {
		temp.add(k);
	}

	public int next_dest() {
		if (dr == direction.DOWN)
			return this.down.first();
		if (dr == direction.UP)
			return this.up.first();
		return -1;
	}

	public static void add_dest(Integer p) {
		if (sos && temp.size() == 0) {
			dr = direction.ATHALT;
			up.forEach(a -> {
				temp.add(a);
			});
			down.forEach(a -> {
				temp.add(a);
			});
			up.clear();
			down.clear();
		}
		if (p > current)
			up.add(p);
		else {
			down.add(p);
		}
	}

	public void cut_emergency() {
		temp.clear();
		up.clear();
		down.clear();

		if (dr == direction.UP) {
			if (current == floor_total) {
				add_dest(current - 1);
			} else {
				add_dest(current + 1);
			}
		} else if (dr == direction.DOWN) {
			if (current == 0) {
				add_dest(1);
			} else {
				add_dest(current - 1);
			}
		}

	}

	public boolean pop_up(String s) {
		if (s == "up") {
			up.remove(up.first());

			if (up.size() == 0) {
				dr = direction.ATHALT;
			}
		} else {
			down.remove(down.first());

			if (down.size() == 0) {
				dr = direction.ATHALT;
			}
		}
		return true;
	}

	public static void get_newfloor() {
		Random r = new Random();
		int c = r.nextInt(floor_total);
		val = c;
		System.out.println("New Floor- " + c);
		if (sos == true)
			add_temp(c);
		else
			add_dest(c);
	}

	public static void get_sos_floor() {
		sos = true;
		Random r = new Random();
		int c = r.nextInt(floor_total);
		System.out.println("Emergency Floor- " + c);
		if (sos == true)
			add_dest(c);
	}

	TimerTask movement = new TimerTask() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (coming == false) {
				if (checker()) {
					direct();
					coming = true;
				}
			}
		}
	};

	@Override
	public void finalize() throws Throwable {
		// TODO Auto-generated method
		t.cancel();
		movement.cancel();
	}

}