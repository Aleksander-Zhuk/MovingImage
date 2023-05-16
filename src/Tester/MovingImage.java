package Tester;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class MovingImage extends JFrame implements ActionListener {
    private ImageIcon image;
    private JPanel panel;
    private JPanel panel2;
    private JButton button;
    private File file;
    private BufferedImage bufferedImage;
    private WritableRaster raster;
    MovingImage() throws IOException {
        super("Перекраска");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        file = new File("src/DVD.png");
        bufferedImage = ImageIO.read(file);
        raster = bufferedImage.getRaster();
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.drawImage(bufferedImage, 30, 30, null);}};
        //image = new ImageIcon("src/DVD.png");
        panel.setSize(500, 500);
        getContentPane().add(panel);
        setVisible(true);
        for (int x = 0; x < raster.getWidth(); x++){
            for (int y = 0; y < raster.getHeight(); y++){
                int[] pixel = raster.getPixel(x, y, new int[4]);
                pixel[0] = 71;
                pixel[1] = 255;
                pixel[2] = 6;
                raster.setPixel(x, y, pixel);
            }
        }
        bufferedImage.setData(raster);
        ImageIO.write(bufferedImage, "PNG", new File("src/DVD.png"));
    }
    public static void main(String[] args) throws IOException {



        new MovingImage();
       }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}