package org.oleynik.training.selenium.model;

public class RGBA {
    private int red;
    private int green;
    private int blue;
    private double alpha;

    public RGBA(int red, int green, int blue, double alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public double getAlpha() {
        return alpha;
    }

    public boolean isGray() {
        return (red == green && green == blue);
    }

    public boolean isRed() {
        return (green == 0 && blue == 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RGBA rgba = (RGBA) o;

        if (red != rgba.red) return false;
        if (green != rgba.green) return false;
        if (blue != rgba.blue) return false;
        return Double.compare(rgba.alpha, alpha) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        temp = Double.doubleToLongBits(alpha);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
