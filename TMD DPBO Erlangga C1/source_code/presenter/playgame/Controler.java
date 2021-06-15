package presenter.playgame;

import java.awt.event.*;

public class Controler {
	protected int tinggiw;
	protected int lebarw;
	public KeyboardInput keyboard;

	public Controler(int lebar, int tinggi) {
		tinggiw = tinggi;
		lebarw = lebar;
		keyboard = new KeyboardInput();
	}

	public void processInput(Player character) {
		//
		keyboard.poll();
		// If moving up
		if (keyboard.keyDown(KeyEvent.VK_UP)) {
			if (!character.lompat && character.infloor) {
				character.lompat = true;
				character.targetLompat = character.y - character.jarakLompat;
			}
		}
		// If moving left
		if (keyboard.keyDown(KeyEvent.VK_LEFT)) {
			character.x -= character.dx;
			// Check collision with left
			if (character.x < 0)
				character.x = 0;
		}
		// If moving right
		if (keyboard.keyDown(KeyEvent.VK_RIGHT)) {
			character.x += character.dx;
			// Check collision with right
			if (character.x + character.lebar > lebarw - 1)
				character.x = lebarw - character.lebar - 1;
		}
	}

	public boolean ExitInput() {
		keyboard.poll();
		if (keyboard.keyDownOnce(KeyEvent.VK_SPACE)) {
			return true;
		}
		return false;
	}
}