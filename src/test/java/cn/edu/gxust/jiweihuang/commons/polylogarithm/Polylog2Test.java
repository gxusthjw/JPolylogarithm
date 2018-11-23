package cn.edu.gxust.jiweihuang.commons.polylogarithm;

import org.hipparchus.complex.Complex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Polylog2Test {

    @Test
    void cl2() {
    }

    @Test
    void li2() {
        System.out.println(PolyLog2.Li2(0.5));
        assertEquals(PolyLog2.Li2(0.5), 0.5822405264650127, PolyLog2.EPSILON);
        assertEquals(PolyLog2.Li2(0), 0., PolyLog2.EPSILON);
        assertEquals(PolyLog2.Li2(-0.5), -0.448414206923646, PolyLog2.EPSILON);
        assertEquals(PolyLog2.Li2(-0.2), -0.19080013777753566, PolyLog2.EPSILON);
        System.out.println(PolyLog2.Li2(0.2));
        System.out.println(PolyLog2.Li2(new Complex(2, 0)));
        System.out.println(PolyLog2.Li2(new Complex(-2, 0)));
        //assertEquals(Polylog2.Li2(2),0.582240526465012,Polylog2.EPSILON);

        System.out.println(PolyLog2.Li2(0.27));
        System.out.println(PolyLog2.Li2(-0.38));
        System.out.println(PolyLog2.Li2(0.82));
        System.out.println(PolyLog2.Li2(new Complex(2.2)));
        System.out.println(PolyLog2.Li2(new Complex(3.32)));
        System.out.println(PolyLog2.Li2(new Complex(4.52)));

        System.out.println(PolyLog2.Li2(0.2));
        System.out.println(PolyLog2.Li2(0.32));
        System.out.println(PolyLog2.Li2(0.52));
        System.out.println(PolyLog2.Li2(new Complex(0.2)));
        System.out.println(PolyLog2.Li2(new Complex(0.32)));
        System.out.println(PolyLog2.Li2(new Complex(0.52)));
    }

    @Test
    void li2c() {
    }
}