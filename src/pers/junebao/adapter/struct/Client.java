package pers.junebao.adapter.struct;

/**
 * @author JuneBao
 * @date 2020/5/26 23:11
 */
public class Client {
    public void test(Target target){
        System.out.println(target);
    }

    public static void main(String[] args) {
        new Client().test(new Adapter(new Give()));
    }
}
