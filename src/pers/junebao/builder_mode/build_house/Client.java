package pers.junebao.builder_mode.build_house;

public class Client {
    public static void main(String[] args) {
        new BuildHouseDirector(new BuildThatchedHouse()).build();
    }
}
