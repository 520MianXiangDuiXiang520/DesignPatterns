package pers.junebao.simple_factory.fitting.camera;

public class CameraFactory {
    public static BaseCamera getCamera(String name) {
        if(name.toLowerCase().equals("leica")) {
            return new Leica();
        } else if (name.toLowerCase().equals("sony")) {
            return new Sony();
        } else {
            return null;
        }
    }
}
