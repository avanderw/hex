package net.avdw.hex.grid;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.GeneralPath;

public class HexGridTest {

    public static void main(String[] args) {
        Frame frame = new Frame("Hex Test") {
            @Override
            public void paint(Graphics g) {
                Graphics2D gfx = (Graphics2D) g;

                HexGrid grid = new HexGrid()
                        .width(6)
                        .height(6)
                        .orientation(HexGrid.Orientation.FLAT)
                        .radius(20D)
                        .build();

                grid.hexagons().forEach(hex -> {
                    GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
                    path.moveTo(hex.corner(0).x, hex.corner(0).y);
                    hex.corners().forEach(corner -> {
                        path.lineTo(corner.x, corner.y);
                    });
                    path.closePath();
                    
                    gfx.setColor(Color.red);
                    gfx.translate(hex.x * hex.width(), hex.y);
                });
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
