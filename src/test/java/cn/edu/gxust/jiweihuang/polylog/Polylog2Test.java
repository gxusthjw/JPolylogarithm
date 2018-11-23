package cn.edu.gxust.jiweihuang.polylog;

import org.hipparchus.complex.Complex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Polylog2Test {

    @Test
    void cl2() {
    }

    @Test
    void li2() {
        System.out.println(Polylog2.Li2(0.5));
        assertEquals(Polylog2.Li2(0.5),0.5822405264650127,Polylog2.EPSILON);
        assertEquals(Polylog2.Li2(0),0.,Polylog2.EPSILON);
        assertEquals(Polylog2.Li2(-0.5),-0.448414206923646,Polylog2.EPSILON);
        assertEquals(Polylog2.Li2(-2),-1.436746366883681,Polylog2.EPSILON);
        System.out.println(Polylog2.Li2(2));
        System.out.println(Polylog2.Li2(new Complex(2,0)));
        System.out.println(Polylog2.Li2(new Complex(-2,0)));
        //assertEquals(Polylog2.Li2(2),0.582240526465012,Polylog2.EPSILON);

        System.out.println(Polylog2.Li2(2.2));
        System.out.println(Polylog2.Li2(3.32));
        System.out.println(Polylog2.Li2(4.52));
        System.out.println(Polylog2.Li2(new Complex(2.2)));
        System.out.println(Polylog2.Li2(new Complex(3.32)));
        System.out.println(Polylog2.Li2(new Complex(4.52)));

        System.out.println(Polylog2.Li2(0.2));
        System.out.println(Polylog2.Li2(0.32));
        System.out.println(Polylog2.Li2(0.52));
        System.out.println(Polylog2.Li2(new Complex(0.2)));
        System.out.println(Polylog2.Li2(new Complex(0.32)));
        System.out.println(Polylog2.Li2(new Complex(0.52)));
    }

    @Test
    void li2c() {
    }
}