package tools;

import java.math.BigDecimal;

import static ncorps.Parametres.*;

public class BD {

    private final BigDecimal val;

    public BD(BigDecimal val) {
        this.val = val;
    }

    public BD(double val) {
        this.val = new BigDecimal(val);
    }

    public static BD plus(BD val1, BD val2) {
        return new BD(val1.val.add(val2.val, mc));
    }

    public static BD plus(BD val1, BD val2, BD val3) {
        return new BD(val1.val.add(val2.val, mc).add(val3.val, mc));
    }

    public static BD moins(BD val1, BD val2) {
        return new BD(val1.val.subtract(val2.val, mc));
    }

    public static BD x(BD val1, BD val2) {
        return new BD(val1.val.multiply(val2.val, mc));
    }

    public static BD div(BD val1, BD val2) {
        return new BD(val1.val.divide(val2.val, scale, rnd));
    }

    public static BD pow(BD val1, int val2) {
        return new BD(val1.val.pow(val2, mc));
    }

    public static BD sqrt(BD val1) {
        return new BD(val1.val.sqrt(mc));
    }

    public static int intValue(BD val1) {
        return val1.val.intValue();
    }
}
