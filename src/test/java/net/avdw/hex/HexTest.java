package net.avdw.hex;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class HexTest {
    
    public static void main(String[] args) {
        Frame frame = new Frame("Hex Test") {
            @Override
            public void paint(Graphics g) {
                Graphics2D gfx = (Graphics2D) g;
                
                Hex hex = new HexFlatTop(20D);
                GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
                path.moveTo(hex.corner(0).x, hex.corner(0).y);
                path.lineTo(hex.corner(1).x, hex.corner(1).y);
                path.lineTo(hex.corner(2).x, hex.corner(2).y);
                path.lineTo(hex.corner(3).x, hex.corner(3).y);
                path.lineTo(hex.corner(4).x, hex.corner(4).y);
                path.lineTo(hex.corner(5).x, hex.corner(5).y);
                path.closePath();
                
                gfx.setColor(Color.red);
                gfx.translate(150, 150);
                gfx.fill(path);
                
                hex = new HexPointyTop(hex);
                path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
                path.moveTo(hex.corner(0).x, hex.corner(0).y);
                path.lineTo(hex.corner(1).x, hex.corner(1).y);
                path.lineTo(hex.corner(2).x, hex.corner(2).y);
                path.lineTo(hex.corner(3).x, hex.corner(3).y);
                path.lineTo(hex.corner(4).x, hex.corner(4).y);
                path.lineTo(hex.corner(5).x, hex.corner(5).y);
                path.closePath();
                
                gfx.setColor(Color.red);
                gfx.translate(100, 0);
                gfx.fill(path);
            }
        };
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose(); 
                System.exit(0);
            }
        });
        
    }
}
