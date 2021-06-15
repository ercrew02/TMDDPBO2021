package presenter.playgame;

import java.awt.*;
import javax.swing.ImageIcon;

public class Box extends GameObject {
    int lebar, tinggi, lebarw, tinggiw;
    // lebar untuk lebar box
    // tinggi untuk tinggi box
    // lebarw tinggiw untuk ukuran window
    boolean moving;
    // menentukan gerakan (left right)
    Color color;
    // warna box

    public Box(int x, int y, ID id, int lebarw, int tinggiw, boolean moving, Color color) {
        // kontainer box
        super(x, y, id);
        this.lebar = 90;
        this.tinggi = 50;
        this.lebarw = lebarw;
        this.tinggiw = tinggiw;
        this.moving = moving;
        this.color = color;
        inArea = true;
        stepped = false;
    }

    @Override
    public void tick(Player player, Score score) {
        // untuk method yg diulang
        collusion(player, score);
        if (moving) {
            movingLeft();
        } else {
            movingRight();
        }
    }

    @Override
    public void render(Graphics g) {
        // untuk menggambar box
        Image image = new ImageIcon(this.getClass().getResource("bubble.png")).getImage();
        g.drawImage(image, x, y, lebar, tinggi, null);
    }

    private void movingLeft() {
        // untuk memindahkan box ke kiri
        x -= 1;
        if (x + lebar < 0) {
            inArea = false;
        }

    }

    private void movingRight() {
        // untuk memindahkan box ke kanan
        x += 1;
        if (x > lebarw - 1) {
            inArea = false;
        }
    }

    private void collusion(Player player, Score score) {
        // untuk menandakan player bertabrakan dengan box
        int boxLeft = x;
        int boxRight = x + this.lebar;
        int boxTop = y;
        int boxBottom = y + this.tinggi;

        int playerLeft = player.x;
        int playerRight = player.x + player.lebar;
        int playerTop = player.y;
        int playerBottom = player.y + player.tinggi;

        if ((boxLeft <= playerRight) && (boxRight >= playerLeft)) {
            if (boxTop <= playerBottom && boxTop >= playerTop) {
                player.infloor = true;
                player.y = boxTop - player.tinggi;
                stepped = true;
                // System.out.println("Top");
            } else if ((boxTop < playerTop) && (boxBottom > playerBottom)) {
                if ((playerRight > boxLeft) && (playerLeft < boxLeft)) {
                    player.x = boxLeft - player.tinggi;
                } else if ((playerLeft < boxRight) && (playerRight > boxRight)) {
                    player.x = boxRight;
                }
            } else if (boxBottom >= playerTop && boxTop <= playerTop) {
                // System.out.println("Bawah");
                if (player.lompat) {
                    score.tambahFail();
                }
                player.lompat = false;
            }
        }
    }
}