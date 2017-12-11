package net.avdw.hex.grid;

public class Axial {

    Cube toCube() {
        Double x = hex.q;
        Double z = hex.r;
        Double y = -x - z;
        return new Cube(x, y, z);
    }
}
