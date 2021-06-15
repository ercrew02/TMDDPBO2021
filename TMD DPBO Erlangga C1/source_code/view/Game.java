package view;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import presenter.playgame.*;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game extends Canvas implements Runnable {
	public int lebar = 800;
	public int tinggi = 600;
	Windows win;
	private Thread thread;
	// membuat variabel u/ thread
	BufferStrategy buffer;
	GraphicsEnvironment ge;
	GraphicsDevice gd;
	GraphicsConfiguration gc;
	BufferedImage bi;
	Graphics graphics;
	Graphics2D g2d;
	private Clip song;
	// membuat variabel untuk lagu
	Color background;
	boolean running = false;
	Player player = new Player();
	Score score = new Score();
	CreateBox createBoxL1 = new CreateBox(lebar, tinggi, ID.BoxL1, randomColor());
	CreateBox createBoxL2 = new CreateBox(lebar, tinggi, ID.BoxL2, randomColor());
	CreateBox createBoxL3 = new CreateBox(lebar, tinggi, ID.BoxL3, randomColor());
	// membuat box sesuai level

	Floor floor = new Floor(lebar, tinggi);
	// membuat lantai

	Menu menu;
	// membuat variabel menu

	Controler control = new Controler(lebar, tinggi);
	// membuat variabel control
	int timeBoxDown = 0;
	// membuat variabel timeboxdown

	public Game(String title, Menu menu) {
		// kontainer game
		this.menu = menu;
		win = new Windows(lebar, tinggi, title, this);
		// memanggil class windows
		playSong("/instrumen.wav");
		// file lagu

	}

	@Override
	public void run() {
		// method run untuk running game
		drawInit();
		while (running) {
			createBoxL1.tick(player, score);
			createBoxL2.tick(player, score);
			createBoxL3.tick(player, score);
			// setiap box memanggil method tick

			if (control.ExitInput()) {
				// jika inputan spasi
				ProsesSendScore sendScore = new ProsesSendScore();
				// maka data diproses
				sendScore.send(menu.nama, score);
				// mengirim data score
				win.closeWindow();
				// lalu windows diclose
				stop();
				// untuk memberhentikan thread
				break;
			}
			control.processInput(player);
			addKeyListener(control.keyboard);
			// input keyboard
			drawLoop();
			// pengulangan menggambar tampilan
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	private void drawInit() {
		// menggambar awal
		createBufferStrategy(2);
		buffer = getBufferStrategy();
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();
		bi = gc.createCompatibleImage(lebar, tinggi);
		graphics = null;
		g2d = null;
		background = Color.WHITE;
	}

	public void drawCharacter() {
		// menggambar karakter
		Image image = new ImageIcon(this.getClass().getResource("spongebob.png")).getImage();
		g2d.drawImage(image, player.x, player.y, player.lebar, player.tinggi, null);
		player.effectGravitasi();
		floor.collusion(player);
	}

	public void drawFloor() {
		// menggambar lantai
		Image image = new ImageIcon(this.getClass().getResource("box.png")).getImage();
		g2d.drawImage(image, floor.x, floor.y, floor.lebar, floor.tinggi, null);
	}

	public void drawString(String string, int x, int y) {
		// menggambar tulisan score
		g2d.setColor(Color.WHITE);
		g2d.drawString(string, x, y);
	}

	public void drawLoop() {
		// menggambar gambar yg diulang2
		g2d = bi.createGraphics();
		Image image = new ImageIcon(this.getClass().getResource("background.png")).getImage();
		g2d.drawImage(image, 0, 0, lebar, tinggi, null);
		drawCharacter();
		drawFloor();
		changeLevel();
		drawString("Success : " + score.getSuccess(), 5, 20);
		drawString("Fail : " + score.getFail(), 5, 40);
		createBoxL1.render(g2d);
		createBoxL2.render(g2d);
		createBoxL3.render(g2d);
		graphics = buffer.getDrawGraphics();
		graphics.drawImage(bi, 0, 0, null);
		if (!buffer.contentsLost())
			buffer.show();
	}

	public void drawDispose() {
		// untuk menghilangkan gambar
		if (graphics != null)
			graphics.dispose();
		if (g2d != null)
			g2d.dispose();
	}

	public synchronized void start() {
		// untuk memulai thread
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		// menstop thread
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeLevel() {
		// menukarkan lantai
		if (createBoxL1.boxReadyDown) {
			if (timeBoxDown == 0) {
				score.tambahScore();
				createBoxL1 = createBoxL2;
				createBoxL1.id = ID.BoxL1;
				createBoxL1.boxDown();
				createBoxL2 = createBoxL3;
				createBoxL2.id = ID.BoxL2;
				createBoxL2.boxDown();
				createBoxL3 = new CreateBox(lebar, tinggi, ID.BoxL3, randomColor());
				createBoxL1.boxReadyDown = false;
			}
			timeBoxDown--;
		} else {
			timeBoxDown = 50;
		}
	}

	Color randomColor() {
		// mengacak warna box
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		return color;
	}

	public void playSound(String filename) {
		try {
			// Open an audio input stream.
			URL url = this.getClass().getResource(filename);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playSong(String filename) {
		try {
			// Open an audio input stream.
			URL url = this.getClass().getResource(filename);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			song = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			song.open(audioIn);
			song.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}