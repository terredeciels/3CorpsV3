package ncorps;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.Math.random;

class Calculs implements Parametres {


    public final CorpsV2[][] ncorps;
    BigDecimal[] d = new BigDecimal[3];
    Function<Integer, BigDecimal> c = j -> d[j].pow(2, mc);
    BiFunction<Integer, CorpsV2, BigDecimal> NC = (i, x) -> x.param[i];

    BigDecimal zero = new BigDecimal("0.0");
    BigDecimal demi = new BigDecimal("0.5");

    public Calculs() {
        CORPS.get().forEach(Calculs::init);
        ncorps = NCorpsT0;
        T.get().forEach(t -> CORPS.get().forEach(n -> {
            BigDecimal[] f = new BigDecimal[]{zero, zero, zero};
            CORPS.get().filter(m -> n != m).forEach(m -> {
                CorpsV2 corpsn = ncorps[n][t];
                CorpsV2 corpsm = ncorps[m][t];

                CORPS.get().forEach(i -> d[i] = corpsn.param[i].subtract(corpsm.param[i]));
                BigDecimal Denom = c.apply(0).add(c.apply(1)).add(c.apply(2)).sqrt(mc).pow(3, mc);
                CORPS.get().forEach(i -> f[i] = f[i].add(Gm.multiply(d[i].divide(Denom, scale, rnd))));

                CorpsV2 corpsV2 = new CorpsV2(n);

                CORPS.get().forEach(i -> corpsV2.param[i] = demi.multiply(f[i].multiply(pas.pow(2)))
                        .add((corpsn.param[i + 3]).multiply(pas)).add(corpsn.param[i]));
                CORPS.get().forEach(i -> corpsV2.param[i + 3] = f[i].multiply(pas).add(corpsn.param[i + 3]));

                ncorps[n][t + 1] = corpsV2;
            });

        }));

    }


    private static void init(int n) {
        CorpsV2 corpsV2 = new CorpsV2(n);
        COORD.get().forEach(c -> corpsV2.param[c] = new BigDecimal(random() * DimXYZ));
        VIT.get().forEach(c -> corpsV2.param[c] = new BigDecimal(0));
        NCorpsT0[n][t0] = corpsV2;
    }


    static class CorpsV2 {

        public BigDecimal[] param;
        public int num;

        public CorpsV2(int num) {
            this.num = num;
            param = new BigDecimal[6];
        }

//         public CorpsV2() {
//            param = new BigDecimal[6];
//        }

    }
}

