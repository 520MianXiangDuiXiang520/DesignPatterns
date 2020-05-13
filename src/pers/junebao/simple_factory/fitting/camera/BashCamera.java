package pers.junebao.simple_factory.fitting.camera;

public abstract class BashCamera {
    public String pixel;
    public String brand;

    BashCamera(String brand, String pixel) {
        this.pixel = pixel;
        this.brand = brand;
    }
}
