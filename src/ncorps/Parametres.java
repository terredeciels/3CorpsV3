package ncorps;

import tools.BD;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;
import static tools.BD.pow;

public interface Parametres {
    int NbCorps = 3;
    int Tmax = 1000;
    Supplier<IntStream> I = () -> range(0, NbCorps);
    Supplier<IntStream> COORD = () -> range(0, 3);
    Supplier<IntStream> VIT = () -> range(3, 6);
    Supplier<IntStream> T = () -> range(0, Tmax - 1);
    BD[] d = new BD[3];
    BiFunction<Integer, Calculs.Corps, BD> NC = (i, x) -> x.param[i];
    BD zero = new BD(0.0);
    BD DEMI = new BD(0.5);
    int t0 = 0;
    int DimXYZ = 600;
    BD Gm = new BD(-1.0);
    BD pas = new BD(10.0);
    int scale = 12;
    int precision = 12;
    MathContext mc = new MathContext(precision);
    Function<Integer, BD> c = j -> pow(d[j], 2);
    RoundingMode rnd = RoundingMode.HALF_DOWN;

    Calculs.Corps[][] NCorpsT0 = new Calculs.Corps[3][Tmax];

    String pathname = "C:\\Users\\gille\\IdeaProjects\\3CorpsV2\\";
    String filename1 = "3corpsX";
    String filename2 = "CorpsN";

}
