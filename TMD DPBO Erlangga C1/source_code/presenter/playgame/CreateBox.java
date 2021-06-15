package presenter.playgame;

import java.awt.*;
import java.util.Random;

public class CreateBox {
	public Handler handler;
	public ID id;
	int lebarw, tinggiw, timeAddBox, timeDelBox, y;
	Color color;
	public boolean moveBox, boxReadyDown = false;
	Random rd = new Random();

	public CreateBox(int lebar, int tinggi, ID id, Color color) {
		lebarw = lebar; // lebar box
		tinggiw = tinggi; // tinggi box
		this.color = color;
		// memindahkan color parameter ke class
		this.id = id;
		handler = new Handler();
		moveBox = rd.nextBoolean();
		timeAddBox = 0;
		timeDelBox = 0;
		// System.out.println(moveBox);
	}

	public void setY(ID idt) {
		// Menentukan Y
		if (idt == ID.BoxL1) {
			y = tinggiw / 2 + 120;
		} else if (idt == ID.BoxL2) {
			y = tinggiw / 2;
		} else if (idt == ID.BoxL3) {
			y = tinggiw / 2 - 120;
		}
	}

	public void tick(Player player, Score score) {
		// method yg diulang perdetik
		handler.tick(player, score);
		setY(this.id);
		AddBox(this.id, moveBox);
		delObject();
		playerStepped();
	}

	int setX(boolean moveBox) {
		// Menentukan X
		int x;
		if (!moveBox) {
			x = -100;
		} else {
			x = lebarw + 100;
		}
		return x;
	}

	public void AddBox(ID idL, boolean moveBox) {
		// Menambah box
		int x = setX(moveBox);

		if (timeAddBox >= 100) {
			timeAddBox = 0;
		}
		if (timeAddBox == 0) {
			int max = 3;
			int min = 1;
			int range = max - min + 1;
			int hasil = rd.nextInt(range) + min;
			if (hasil % 2 != 0) {
				handler.addObject(new Box(x, this.y, idL, lebarw, tinggiw, moveBox, this.color));
			}
		}
		timeAddBox++;
	}

	public void render(Graphics g) {
		// Menggambar
		handler.render(g);
	}

	void playerStepped() {
		// Jejak Player
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tampBox = handler.object.get(i);
			if (tampBox.stepped) {
				if (timeDelBox == 50) {
					moveBox = rd.nextBoolean();
					delObjectByID();
					timeDelBox = 0;
				}
				timeDelBox++;
			}
		}
	}

	public void boxDown() {
		// box turun
		int i = 0;
		while (handler.object.size() != i) {
			handler.object.get(i).id = this.id;
			handler.object.get(i).y += 120;
			i++;
		}
	}

	private void delObject() {
		// menghapus box
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tampBox = handler.object.get(i);
			if (!tampBox.inArea) {
				handler.removeObject(handler.object.get(i));
			}
		}
	}

	private void delObjectByID() {
		while (handler.object.size() != 0) {
			handler.object.remove();
			boxReadyDown = true;
		}
	}
}