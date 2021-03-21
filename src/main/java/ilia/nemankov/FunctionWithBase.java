package ilia.nemankov;

public abstract class FunctionWithBase extends Function {

    private int base;

    public FunctionWithBase(double precision, int base) {
        super(precision);
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

}
