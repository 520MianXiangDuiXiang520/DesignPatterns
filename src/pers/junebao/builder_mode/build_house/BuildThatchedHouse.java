package pers.junebao.builder_mode.build_house;

public class BuildThatchedHouse implements BuildHoseBase {
    @Override
    public void foundation() {
        System.out.println("茅草屋打什么地基");
    }

    @Override
    public void buildWall() {
        System.out.println("插一圈竹子做墙");
    }

    @Override
    public void buildTop() {
        System.out.println("房顶搭上茅草");
    }

    @Override
    public void decoration() {
        System.out.println("门口种朵花");
    }
}
