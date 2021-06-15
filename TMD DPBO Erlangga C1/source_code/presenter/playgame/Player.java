package presenter.playgame;

public class Player {
	public int x, y, lebar, tinggi, dx, dy;
	public boolean lompat = false;
	public boolean infloor = false;
	public int targetLompat = 0;
	public int jarakLompat = 200;

	public Player() {
		super();
		x = y = 0;
		dx = dy = 5;
		lebar = 60;
		tinggi = 40;
	}

	public void effectGravitasi() {
		// System.out.println("Lompat = " + lompat);
		// System.out.println("DiLantai = " + infloor);
		// jika tidak lompat maka gerak bertambah 5
		if (!lompat) {
			y += dy;
		} else {
			// maka tidak lompat
			playerLompat();
			// maka panggil method lompat
		}
	}

	public void playerLompat() {
		// method lompat
		if (y > targetLompat) {
			y -= dy;
			infloor = false;
		} else {
			lompat = false;
		}
	}
}