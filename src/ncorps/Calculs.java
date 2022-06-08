package ncorps;

import tools.BD;

import java.util.function.Function;

import static java.lang.Math.random;
import static tools.A.browse;
import static tools.BD.*;

public class Calculs implements Parametres {


    public final Corps[][] ncorps;
    Function<Integer, BD> G, H, R, S;

    public Calculs() {
        I.get().forEach(Calculs::init);
        ncorps = NCorpsT0;
        T.get().forEach(k -> I.get().forEach(n -> {
            BD[] f = new BD[]{zero, zero, zero};
            I.get().filter(m -> n != m).forEach(m -> {
                Corps cn = ncorps[n][k];
                Corps cm = ncorps[m][k];

                G = i -> d[i] = moins(cn.param[i], cm.param[i]);
                browse.accept(G);

                BD Denom = pow(sqrt(plus(pow(d[0], 2), pow(d[1], 2), pow(d[2], 2))), 3);

                H = i -> f[i] = plus(f[i], x(Gm, div(d[i], Denom)));
                browse.accept(H);

                ncorps[n][k + 1] = new Corps();

                R = i -> ncorps[n][k + 1].param[i] = plus(x(DEMI, x(f[i], pow(pas, 2))), x(cn.param[i + 3], pas), cn.param[i]);
                browse.accept(R);

                S = i -> ncorps[n][k + 1].param[i + 3] = plus(x(f[i], pas), cn.param[i + 3]);
                browse.accept(S);

            });

        }));

    }


    private static void init(int n) {
        NCorpsT0[n][t0] = new Corps();
        COORD.get().forEach(c -> NCorpsT0[n][t0].param[c] = new BD(random() * DimXYZ));
        VIT.get().forEach(c -> NCorpsT0[n][t0].param[c] = new BD(0));
    }


    public static class Corps {

        public BD[] param;


        public Corps() {

            param = new BD[6];
        }


    }
}

