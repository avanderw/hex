package net.avdw.hex;

import net.avdw.vector.Vector2D;

class HexFlatTop extends Hex {


    HexFlatTop(Double radius) {
        this.radius = radius;
    }

    HexFlatTop(Hex hex) {
        this.radius = hex.radius();
    }

    @Override
    public Vector2D corner(Integer corner) {
        Double degrees = 60 * corner.doubleValue();

        Double radians = Math.PI / 180 * degrees;

        Vector2D point = new Vector2D();
        point.offsetPolar(radius, radians);
        return point;
    }

    @Override
    public Double width() {
        return radius * 2;
    }

    @Override
    public Double height() {
        return Math.sqrt(3) / 2 * width();
    }

    @Override
    public Double verticalSpacing() {
        return height();
    }

    @Override
    public Double horizontalSpacing() {
        return width() * 3 / 4;
    }
}
