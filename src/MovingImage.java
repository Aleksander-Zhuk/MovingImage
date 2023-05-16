import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MovingImage extends JFrame implements ActionListener {
    private JPanel panel;
    private ImageIcon image;
    private Timer timer;
    private Random random;
    private File file;
    private BufferedImage bufferedImage;
    private WritableRaster raster;
    private int x, y, xDirection = 1, yDirection = 1;

    public MovingImage() throws IOException {
        super("Moving Image");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        file = new File("src/DVD.png");
        bufferedImage = ImageIO.read(file);
        raster = bufferedImage.getRaster();
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.drawImage(bufferedImage, x, y,this );
            }
        };
        panel.setSize(500, 500);
        panel.setBackground(Color.BLACK);
        getContentPane().add(panel);
        timer = new Timer(2, this);
        timer.start();
        setVisible(true);
        random = new Random();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // премещение картинки отражаясь от краёв и при этом меняя цвет
        x += xDirection;
        y += yDirection;
        if (x <= 0 || x >= getWidth() - bufferedImage.getWidth()) {
            xDirection *= -1;
            int a = random.nextInt(256);
            int b = random.nextInt(256);
            int c =  random.nextInt(256);
            for (int x = 0; x < raster.getWidth(); x++){
                for (int y = 0; y < raster.getHeight(); y++){
                    int[] pixel = raster.getPixel(x, y, new int[4]);
                    pixel[0] = a;
                    pixel[1] = b;
                    pixel[2] = c;
                    raster.setPixel(x, y, pixel);
                }
            }
            bufferedImage.setData(raster);
            try {
                ImageIO.write(bufferedImage, "PNG", new File("src/DVD.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (y <= 0 || y >= getHeight() - bufferedImage.getHeight()) {
            yDirection *= -1;
            int a = random.nextInt(256);
            int b = random.nextInt(256);
            int c =  random.nextInt(256);
            for (int x = 0; x < raster.getWidth(); x++){
                for (int y = 0; y < raster.getHeight(); y++){
                    int[] pixel = raster.getPixel(x, y, new int[4]);
                    pixel[0] = a;
                    pixel[1] = b;
                    pixel[2] = c;
                    raster.setPixel(x, y, pixel);
                }
            }
            bufferedImage.setData(raster);
            try {
                ImageIO.write(bufferedImage, "PNG", new File("src/DVD.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        panel.repaint();
    }
    public static void main(String[] args) throws IOException {
        MovingImage frame = new MovingImage();
    }
}
         // для преремещения по пириметру
         /*if (x == 0 & y == 0 ){
         x+=1;
         }else {if (x < panel.getWidth() - image.getIconWidth() & y == 0){
        x+=1;
        }else { if (x >= panel.getWidth() - image.getIconWidth() & y ==0 ){
        y+=1;
        }else { if (x >= panel.getWidth() - image.getIconWidth() & y < panel.getHeight() - image.getIconHeight()){
        y+=1;
        }else { if (y >= panel.getHeight() - image.getIconHeight() & x >= panel.getWidth() - image.getIconWidth() ){
        x-=1;
        }else { if (x !=0 & y >= panel.getHeight() - image.getIconHeight()){
        x-=1;
        }else { if (x == 0 & y >= panel.getHeight() - image.getIconHeight()){
        y-=1;
        }else { if (y !=0 & x==0 ){
        y-=1;
        }}}}}}}}*/

         // для перемещения по диогонали в низ и возврощать обратно
        /*if (x > panel.getWidth() || y > panel.getHeight()-image.getIconHeight()) {
            x = 0;
            y = 0;*/