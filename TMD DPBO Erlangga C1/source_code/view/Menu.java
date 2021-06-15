package view;

import presenter.*;
import javax.swing.*;
//import folder presenter

public class Menu extends JFrame implements Runnable {
        private JButton JBExit;
        private JButton JBMulai;
        private JLabel JLNama;
        private JPanel JPJudul;
        private JScrollPane JSTabel;
        private JTextField JTFNama;
        private JTable JTScore;
        private JLabel Judul;
        private JPanel jPanel2;
        private JPanel jPanel3;
        private DataTabel dataTabel;
        private String data[][] = new String[100][100];
        public String nama;

        public Menu() {
                // kontainer menu
                dataTabel = new DataTabel();
                // memanggil class dataTabel
        }

        public void initComponents() {
                JPJudul = new JPanel();
                Judul = new JLabel();
                jPanel2 = new JPanel();
                JTFNama = new JTextField();
                JLNama = new JLabel();
                jPanel3 = new JPanel();
                JBExit = new JButton();
                JBMulai = new JButton();
                JSTabel = new JScrollPane();

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Judul.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
                Judul.setText("THE HIGHEST LEVEL");

                GroupLayout JPJudulLayout = new GroupLayout(JPJudul);
                JPJudul.setLayout(JPJudulLayout);
                JPJudulLayout.setHorizontalGroup(JPJudulLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(JPJudulLayout.createSequentialGroup().addGap(245, 245, 245)
                                                .addComponent(Judul, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGap(262, 262, 262)));
                JPJudulLayout.setVerticalGroup(JPJudulLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(JPJudulLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(Judul, GroupLayout.PREFERRED_SIZE, 41,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

                JLNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                JLNama.setText("Username :");
                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(250, 250, 250)
                                                .addComponent(JLNama, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18).addComponent(JTFNama, GroupLayout.PREFERRED_SIZE,
                                                                104, GroupLayout.PREFERRED_SIZE)
                                                .addGap(259, 259, 259)));
                jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(JLNama).addGap(0, 0,
                                                Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(JTFNama)
                                                .addContainerGap()));
                JSTabel.setViewportView(JTScore);

                JBExit.setText("EXIT");
                JBExit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                JBExitActionPerformed(evt);
                        }
                });

                JBMulai.setText("MULAI");
                JBMulai.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                JBPlayActionPerformed(evt);
                        }
                });
                GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(JBMulai, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(78, 78, 78).addComponent(JBExit, GroupLayout.PREFERRED_SIZE,
                                                                101, GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66)));
                jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                .addComponent(JBMulai, GroupLayout.DEFAULT_SIZE, 49,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(JBExit, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(JPJudul, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(169, 169, 169)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(JSTabel, GroupLayout.PREFERRED_SIZE, 0,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(158, 158, 158)));
                layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup().addContainerGap()
                                .addComponent(JPJudul, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSTabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(jPanel3, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(84, Short.MAX_VALUE)));
                pack();
        }

        @Override
        public void run() {
                // method run
                setVisible(true);
                // memunculkan window menu
                data = dataTabel.getData();
                // memindahkan data dari database ke variabel data
                String Column[] = { "Username", "Fail", "Success" };
                // untuk kolom tabel
                JTScore = new JTable(data, Column);
                // variabel data dan kolom dipindahkan ke tabel
                ;
                initComponents();
        }

        private void JBExitActionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                // untuk menghilangkan windows
        }

        private void JBPlayActionPerformed(java.awt.event.ActionEvent evt) {
                nama = JTFNama.getText();
                // untuk mengambil input Nama
                new Game("GAME PLAYING", this);
                // memanggil class game
                dispose();
                // untuk menghilangkan windows
        }

}
