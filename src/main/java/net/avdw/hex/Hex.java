package net.avdw.hex;

import java.util.ArrayList;
import java.util.List;
import net.avdw.vector.Vector2D;

public abstract class Hex {

    protected Double radius = 1D;

    public final List<Vector2D> corners() {
        List<Vector2D> corners = new ArrayList();
        for (int i = 0; i < 6; i++) {
            corners.add(corner(i));
        }

        return corners;
    }

    abstract public Vector2D corner(Integer corner);

    abstract public Double height();

    abstract public Double horizontalSpacing();

    abstract public Double verticalSpacing();

    abstract public Double width();

    public final Double radius() {
        return radius;
    }
}
