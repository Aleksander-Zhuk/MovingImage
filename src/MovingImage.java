import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class MovingImage extends JFrame implements ActionListener {
    private JPanel panel;
    private ImageIcon image;
    private Timer timer;
    private int x, y;
    public MovingImage() {
        super("Moving Image");
        setForeground(Color.orange);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel() { @Override protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image.getImage(), x, y, null);
            } };
        panel.setBackground(Color.WHITE);
        image = new ImageIcon("src/5.png");
        panel.setSize(500, 500);
        //panel.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        getContentPane().add(panel);
        timer = new Timer(2, this);
        timer.start();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (x == 0 & y == 0 ){
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
        }}}}}}}}
        panel.repaint();
    }
    public static void main(String[] args) throws IOException {
        MovingImage frame = new MovingImage();
    }
}
        /*if (x > panel.getWidth() || y > panel.getHeight()-image.getIconHeight()) {
            x = 0;
            y = 0;*/