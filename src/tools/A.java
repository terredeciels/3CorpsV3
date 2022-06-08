package tools;


import ncorps.Calculs;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;
import static ncorps.Parametres.NbCorps;
import static ncorps.Parametres.d;
import static tools.BD.moins;

public class A<T> {


   static BiFunction<Integer, Integer, Supplier<IntStream>> I = (a, b) -> (Supplier<IntStream>) () -> range(a, b);

   public static Consumer<Function<Integer, BD>> browse = (F) -> I.apply(0, NbCorps).get().forEach(F::apply);

    public A() {
        Function<Integer,BD> G= i -> {
            Calculs.Corps cn = null,cm = null;
            return d[i] = moins(cn.param[i], cm.param[i]);
        };
        browse.accept(G);
    }
}
