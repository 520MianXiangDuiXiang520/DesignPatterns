package pers.junebao.decorator_pattern.decorator;

import pers.junebao.decorator_pattern.Noodles;

public abstract class Burden extends Noodles {
    public Noodles noodles;
    public Burden(Noodles noodles) {
        this.noodles = noodles;
    }
}
