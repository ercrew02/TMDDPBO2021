package presenter.playgame;

import java.awt.Graphics;

public abstract class GameObject {
    // Untuk parents box
    public int x, y;
    public ID id;
    public boolean inArea, stepped;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick(Player player, Score score);

    // method proses perdetik
    public abstract void render(Graphics g);
    // method preses menggambar
}
