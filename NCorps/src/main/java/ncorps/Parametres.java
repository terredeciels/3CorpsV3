package ncorps;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;


public interface Parametres {
    Supplier<IntStream> I = () -> range(0, 3);
    int NbCorps = 3;
    int Tmax = 1000;
    int t0 = 0;
    int DimXYZ = 600;
    BigDecimal Gm = new BigDecimal("-1.0");
    BigDecimal pas = new BigDecimal("10");
    int scale = 12;
    int precision = 12;
    MathContext mc = new MathContext(precision);
    RoundingMode rnd = RoundingMode.HALF_DOWN;

    Corps[][] NCorps = new Corps[3][Tmax];

    String pathname = "C:\\Users\\gille\\IdeaProjects\\3CorpsV2\\";
    String filename1 = "3corpsX";
    String filename2 = "CorpsN";

}
