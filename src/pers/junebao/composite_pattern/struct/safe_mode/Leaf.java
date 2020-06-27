package pers.junebao.composite_pattern.struct.safe_mode;

/**
 * @author JuneBao
 * @date 2020/6/27 22:50
 */
public class Leaf implements Component {
    @Override
    public void showName() {
        System.out.println("Leaf");
    }
}
