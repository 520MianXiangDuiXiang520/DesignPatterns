package pers.junebao.builder_mode.build_house;

public class BuildHouseDirector {
    private BuildHoseBase bb;

    BuildHouseDirector(BuildHoseBase bb){
        this.bb = bb;
    }

    public void build(){
        bb.decoration();
        bb.buildWall();
        bb.buildTop();
        bb.buildTop();
    }
}
