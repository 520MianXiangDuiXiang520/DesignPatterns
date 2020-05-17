package pers.junebao.simple_factory.fitting.camera;

public abstract class BaseCamera {
    public String pixel;
    public String brand;

    BaseCamera(String brand, String pixel) {
        this.pixel = pixel;
        this.brand = brand;
    }
}
