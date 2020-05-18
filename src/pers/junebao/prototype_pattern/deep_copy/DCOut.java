package pers.junebao.prototype_pattern.deep_copy;

public class DCOut {
    private final String outName;
    private In in;

    public DCOut(String outName) {
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
    protected DCOut clone() throws CloneNotSupportedException {
        DCOut copy = (DCOut) super.clone();
        In copyIn = (In) this.in.clone();
        copy.setIn(copyIn);
        return copy;
    }

    public static void main(String[] args) {
        DCOut out = new DCOut("out");
        In in = new In("in name");
        out.setIn(in);

        DCOut out1 = null;
        try {
            // in 是一个object类型，所以在调用clone()时只复制了in的引用
            out1 = out.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assert out1 != null;
        // 改变out1.in的name也会改变out中in的name
        out1.in.setName("out1 in");
        System.out.println(out);
        System.out.println(out1);
    }
}
