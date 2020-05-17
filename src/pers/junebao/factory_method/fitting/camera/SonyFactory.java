package pers.junebao.factory_method.fitting.camera;

import pers.junebao.simple_factory.fitting.camera.BaseCamera;
import pers.junebao.simple_factory.fitting.camera.Sony;

public class SonyFactory implements ICameraFactory {
    @Override
    public BaseCamera createCamera() {
        return new Sony();
    }
}
