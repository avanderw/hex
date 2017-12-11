package net.avdw.hex;

import java.util.ArrayList;
import java.util.List;
import net.avdw.vector.Vector2D;

class HexPointyTop extends Hex {

    HexPointyTop(Double radius) {
        this.radius = radius;
    }

    HexPointyTop(Hex hex) {
        this.radius = hex.radius();
    }

    @Override
    public Vector2D corner(Integer corner) {
        Double degrees = 60 * corner.doubleValue() + 30;
        Double radians = Math.PI / 180 * degrees;

        Vector2D point = new Vector2D();
        point.offsetPolar(radius, radians);
        return point;
    }

    @Override
    public Double width() {
        return Math.sqrt(3) / 2 * height();
    }

    @Override
    public Double height() {
        return radius * 2;
    }

    @Override
    public Double verticalSpacing() {
        return height() * 3 / 4;
    }

    @Override
    public Double horizontalSpacing() {
        return width();
    }
}
