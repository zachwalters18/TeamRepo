import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
public class TeamLogo {


	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Logo Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            
            JPanel canvas = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    Graphics2D g2d = (Graphics2D) g;

                    // Draw sun
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(50, 50, 100, 100);
                

                    // Draw smiley face
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(75, 75, 50, 50);
                    g2d.setColor(Color.BLACK);
                    g2d.drawArc(80, 90, 40, 20, -180, 180);

                    // Draw Eyes on the Sun
                    g2d.setColor(Color.RED);
                    g2d.fillOval(80,75,5,5);
                    g2d.drawOval(80, 75, 5, 5);
                    g2d.setColor(Color.RED);
                    g2d.fillOval(115, 75, 5, 5);
                    g2d.drawOval(115, 75, 5, 5);
                   
                }
            };

            frame.add(canvas);
            frame.setVisible(true);
        });
	}
}
