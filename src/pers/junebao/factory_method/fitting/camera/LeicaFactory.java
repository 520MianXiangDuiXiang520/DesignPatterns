package pers.junebao.factory_method.fitting.camera;

import pers.junebao.simple_factory.fitting.camera.BaseCamera;
import pers.junebao.simple_factory.fitting.camera.Leica;

public class LeicaFactory implements ICameraFactory {
    @Override
    public BaseCamera createCamera() {
        return new Leica();
    }
}
