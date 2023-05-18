import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MovingImage extends JFrame implements ActionListener{
    private JPanel panel;
    private Timer timer;
    private ImageIcon file_sun,file_mercury,file_venus,file_earth
    ,file_mars,file_jupiter,file_saturn,file_uranus,file_neptune;
    private int xsun=350,xmer=455,xven=480,xear=505,xmar=540,xjup=575,xsat=640,xura=705,xnep=750;
    private int ysun=350,ymer=395,yven=395,year=390,ymar=390,yjup=375,ysat=375,yura=385,ynep=385;
    double t = 0;
    public MovingImage() throws IOException {
        super("Moving Image");
        setSize(820, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        file_sun = new ImageIcon("src/Min_png/sun.png");
        file_mercury = new ImageIcon("src/Min_png/mercury.png");
        file_venus = new ImageIcon("src/Min_png/venus.png");
        file_earth = new ImageIcon("src/Min_png/earth.png");
        file_mars = new ImageIcon("src/Min_png/mars.png");
        file_jupiter = new ImageIcon("src/Min_png/jupite.png");
        file_saturn = new ImageIcon("src/Min_png/saturn.png");
        file_uranus = new ImageIcon("src/Min_png/uranus.png");
        file_neptune = new ImageIcon("src/Min_png/neptune.png");
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(file_sun.getImage(), xsun,ysun , null);
                g.drawImage(file_mercury.getImage(), xmer,ymer , null);
                g.drawImage(file_venus.getImage(), xven,yven , null);
                g.drawImage(file_earth.getImage(), xear,year , null);
                g.drawImage(file_mars.getImage(), xmar,ymar, null);
                g.drawImage(file_jupiter.getImage(), xjup,yjup , null);
                g.drawImage(file_saturn.getImage(), xsat,ysat, null);
                g.drawImage(file_uranus.getImage(), xura,yura , null);
                g.drawImage(file_neptune.getImage(), xnep,ynep , null);
            }
        };
        panel.setSize(820, 820);
        panel.setBackground(Color.BLACK);
        getContentPane().add(panel);
        timer = new Timer(20, this);
        timer.start();
        setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        double r = t * Math.PI/180;
        xmer = (int) (60 * Math.cos(r*1.56)) + 395;
        ymer = (int) (60 * Math.sin(r*1.56)) + 395;
        xven = (int) (85 * Math.cos(r*1.16)) + 395;
        yven = (int) (85 * Math.sin(r*1.16)) + 395;
        xear = (int) (115 * Math.cos(r*1)) + 390;
        year = (int) (115 * Math.sin(r*1)) + 390;
        xmar = (int) (150 * Math.cos(r*0.8)) + 390;
        ymar = (int) (150 * Math.sin(r*0.8)) + 390;
        xjup = (int) (200 * Math.cos(r*0.43)) + 375;
        yjup = (int) (200 * Math.sin(r*0.43)) + 375;
        xsat = (int) (265 * Math.cos(r*0.32)) + 375;
        ysat = (int) (265 * Math.sin(r*0.32)) + 375;
        xura = (int) (320 * Math.cos(r*0.22)) + 385;
        yura = (int) (320 * Math.sin(r*0.22)) + 385;
        xnep = (int) (365 * Math.cos(r*0.17)) + 385;
        ynep = (int) (365 * Math.sin(r*0.17)) + 385;
        t++;
        // если нужен цикл повторений
        //if (t == 359) t=0;
        panel.repaint();
        }
    public static void main(String[] args) throws IOException {
        MovingImage frame = new MovingImage();
    }


}