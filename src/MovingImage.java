import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MovingImage extends JFrame implements ActionListener {
    private JPanel panel;
    private Timer timer;
    private File file_Earth;
    private File file_Sun;
    private BufferedImage buffer_Earth;
    private BufferedImage buffer_Sun;
    private int xs = 300, ys = 300, xe = 575, ye = 375;
    double t = 0;
    public MovingImage() throws IOException {
        super("Moving Image");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        file_Earth = new File("src/earth.png");
        file_Sun = new File("src/Sun.png");
        buffer_Earth = ImageIO.read(file_Earth);
        buffer_Sun = ImageIO.read(file_Sun);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.drawImage(buffer_Earth, xe,ye,this );
                g.drawImage(buffer_Sun, xs,ys,this);
            }
        };
        panel.setSize(800, 800);
        panel.setBackground(Color.BLACK);
        getContentPane().add(panel);
        timer = new Timer(100, this);
        timer.start();
        setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        // вращение земли вокруг солнца
        double r = t * Math.PI/180;
        xe = (int) (225 * Math.cos(r)) + 375;
        ye = (int) (225 * Math.sin(r)) + 375;
        t++;
        if (t == 359) t=0;
        panel.repaint();
        }
    public static void main(String[] args) throws IOException {
        MovingImage frame = new MovingImage();
    }
}