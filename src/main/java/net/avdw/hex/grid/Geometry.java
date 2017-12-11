package net.avdw.hex.grid;

import net.avdw.vector.Vector2D;

public class Geometry {

    static Vector2D corner(Vector2D center, Double radius, Integer corner, Orientation orientation) {
        Double angle = 60 * corner.doubleValue();
        if (orientation == Orientation.POINTY) {
            angle += 30;
        }
        angle = Math.PI / 180 * angle;

        Vector2D point = new Vector2D();
        point.offsetPolar(radius, angle);
        return point;
    }

    static Double width(Double radius, Orientation orientation) {
        switch (orientation) {
            case FLAT:
                return radius * 2;
            case POINTY:
                return Math.sqrt(3) / 2 * height(radius, orientation);
            default:
                throw new AssertionError(orientation.name());
        }
    }

    static Double height(Double radius, Orientation orientation) {
        switch (orientation) {
            case FLAT:
                return Math.sqrt(3) / 2 * width(radius, orientation);
            case POINTY:
                return radius * 2;
            default:
                throw new AssertionError(orientation.name());
        }
    }

    static Double verticalSpacing(Double radius, Orientation orientation) {
        switch (orientation) {
            case FLAT:
                return height(radius, orientation);
            case POINTY:
                return height(radius, orientation) * 3 / 4;
            default:
                throw new AssertionError(orientation.name());
        }
    }

    static Double horizontalSpacing(Double radius, Orientation orientation) {

        switch (orientation) {
            case FLAT:
                return width(radius, orientation) * 3 / 4;
            case POINTY:
                return width(radius, orientation);
            default:
                throw new AssertionError(orientation.name());
        }
    }
}
