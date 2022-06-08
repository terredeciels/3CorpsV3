package ncorps;

import java.util.function.Supplier;

import static java.lang.Math.random;

public class Calculs implements Parametres {


    public final Corps[][] ncorps;
    BD ZERO = new BD(0);
    Supplier<BD> RANDOM = () -> new BD(random() * DimXYZ);

    // BiFunction<Integer, Corps, BD> X = (c, C) -> C.xyz[c];

    public Calculs() {
        ncorps = NCorps;
    }


    void init(int n) {
        NCorps[n][t0] = new Corps();
        I.get().forEach(c -> {
            NCorps[n][t0].xyz[c] = RANDOM.get();
            NCorps[n][t0].uvw[c] = ZERO;
        });
    }


}

