package pers.junebao.simple_factory.fitting;

public abstract class Camera {
    public String pixel;
    public String brand;

    Camera(String brand, String pixel) {
        this.pixel = pixel;
        this.brand = brand;
    }
}
