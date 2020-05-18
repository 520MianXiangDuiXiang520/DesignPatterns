package pers.junebao.prototype_pattern.deep_copy;

import java.io.Serializable;

public class Out implements Cloneable, Serializable {
    private final String outName;
    private In in;

    public Out(String outName) {
        this.outName = outName;
    }

    public void setIn(In in) {
        this.in = in;
    }

    @Override
    public String toString() {
        return "Out{" +
                "outName='" + outName + '\'' +
                ", in=" + in +
                '}';
    }

    @Override
    protected Out clone() throws CloneNotSupportedException {
        return (Out) super.clone();
    }

    public static void main(String[] args) {
        Out out = new Out("out");
        In in = new In("in name");
        out.setIn(in);

        Out out1 = null;
        try {
            // in 是一个object类型，所以在调用clone()时只复制了in的引用
            out1 = out.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Out out2 = (Out) DeepClone.deepClone(out);
        assert out1 != null;
        // 改变out1.in的name也会改变out中in的name
        out1.in.setName("out1 in");
        out2.in.setName("out2 in");
        System.out.println(out);
        System.out.println(out1);
        System.out.println(out2);
    }
}
