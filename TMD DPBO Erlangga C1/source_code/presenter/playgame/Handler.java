package presenter.playgame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    // untuk mengumpuklkan objek2(box, player, floor)
    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(Player player, Score score) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick(player, score);
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
