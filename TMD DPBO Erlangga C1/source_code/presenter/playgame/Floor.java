package presenter.playgame;

public class Floor {
    public int x, y, lebar, tinggi;

    public Floor(int lebar, int tinggi) {
        this.x = -3;
        this.y = tinggi - 25;
        this.lebar = lebar + 20;
        this.tinggi = tinggi;
    }

    public void collusion(Player player) {
        // untuk menandakan player bertabrakan dengan LANTAI
        int floorLeft = this.x;
        int floorRight = this.x + this.lebar;
        int floorTop = this.y;
        int floorBottom = this.y + this.tinggi;

        int playerLeft = player.x;
        int playerRight = player.x + player.lebar;
        var playerTop = player.y;
        int playerBottom = player.y + player.tinggi;

        if ((floorLeft < playerRight) && (floorRight > playerLeft)) {
            if (floorTop < playerBottom) {
                player.infloor = true;
                player.y = floorTop - player.tinggi;
            }
        }
    }
}