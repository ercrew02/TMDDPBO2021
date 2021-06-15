package view;

import javax.swing.JFrame;

public class Windows extends JFrame {
    protected int tinggi;
    protected int lebar;

    public Windows(int Lebar, int Tinggi, String title, Game gui) {
        lebar = Lebar;
        tinggi = Tinggi;
        setTitle(title);
        setIgnoreRepaint(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        gui.setSize(lebar, tinggi);
        add(gui);
        pack();
        gui.start();
    }

    public void closeWindow() {
        setVisible(false);
        dispose();
    }
}