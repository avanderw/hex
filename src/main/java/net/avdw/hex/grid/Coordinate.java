package net.avdw.hex.grid;

public class Coordinate {

    static Hex cubeToAxial(Cube cube) {
        Double q = cube.x;
        Double r = cube.z;

        return new Hex(q, r);
    }

    static Cube axialToCube(Hex hex) {
        Double x = hex.q;
        Double z = hex.r;
        Double y = -x - z;

        return new Cube(x, y, z);
    }

    static Hex cubeToOddR(Cube cube) {
        Double col = cube.x + (cube.z - (cube.z & 1)) / 2;
        Double row = cube.z;

        return new Hex(col, row);
    }

    static Cube oddRToCube(Hex hex) {
        Double x = hex.col - (hex.row - (hex.row & 1)) / 2;
        Double z = hex.row;
        Double y = -x - z;

        return new Cube(x, y, z);
    }

    static Hex cubeToEvenR(Cube cube) {
        Double col = cube.x + (cube.z + (cube.z & 1)) / 2;
        Double row = cube.z;

        return new Hex(col, row);
    }

    static Cube evenRToCube(Hex hex) {
        Double x = hex.col - (hex.row + (hex.row & 1)) / 2;
        Double z = hex.row;
        Double y = -x - z;

        return new Cube(x, y, z);
    }

    static Hex cubeToOddQ(Cube cube) {
        Double col = cube.x;
        Double row = cube.z + (cube.x - (cube.x & 1)) / 2;

        return new Hex(col, row);
    }

    static Hex oddQToCube(Hex hex) {
        Double x = hex.col;
        Double z = hex.row - (hex.col - (hex.col & 1)) / 2;
        Double y = -x - z;

        return new Cube(x, y, z);
    }

    static Hex cubeToEvenQ(Cube cube) {
        Double col = cube.x;
        Double row = cube.z + (cube.x + (cube.x & 1)) / 2;

        return new Hex(col, row);
    }

    static Hex evenQToCube(Hex hex) {
        Double x = hex.col;
        Double z = hex.row - (hex.col + (hex.col & 1)) / 2;
        Double y = -x - z;

        return new Cube(x, y, z);
    }
}
