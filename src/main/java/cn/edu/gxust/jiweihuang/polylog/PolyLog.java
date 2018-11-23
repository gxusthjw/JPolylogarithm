/*
 * Copyright (c) 2018-2019, Jiwei Huang. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.edu.gxust.jiweihuang.polylog;

import org.hipparchus.complex.Complex;

/**
 * The class {@code PolyLog} is used to representing Polylogarithm for java.
 * reference: https://baike.baidu.com/item/PolyLog%E5%87%BD%E6%95%B0/9299496
 * reference: https://en.wikipedia.org/wiki/Polylogarithm
 * reference: https://github.com/Expander/polylogarithm
 */
public abstract class PolyLog {
    private final double epsilon = 1.0e-15;
    private final long N = 50;

    private final double[] bernoulli = new double[]{
            1, -0.5, 1. / 6., 0,
            -3.333333333333333e-02, 0, 2.380952380952381e-02, 0,
            -3.333333333333333e-02, 0, 7.575757575757576e-02, 0,
            -2.531135531135531e-01, 0, 1.166666666666667e+00, 0,
            -7.092156862745098e+00, 0, 5.497117794486215e+01, 0,
            -5.291242424242424e+02, 0, 6.192123188405797e+03, 0,
            -8.658025311355312e+04, 0, 1.425517166666667e+06, 0,
            -2.729823106781609e+07, 0, 6.015808739006424e+08, 0,
            -1.511631576709215e+10, 0, 4.296146430611667e+11, 0,
            -1.371165520508833e+13, 0, 4.883323189735932e+14, 0,
            -1.929657934194006e+16, 0, 8.416930475736827e+17, 0,
            -4.033807185405945e+19, 0, 2.115074863808199e+21, 0,
            -1.208662652229652e+23, 0
    };

    private final double[] fac_inv = new double[]{
            1, 0.5, 1. / 6.,
            4.166666666666666e-02, 8.333333333333333e-03, 1.388888888888889e-03,
            1.984126984126984e-04, 2.480158730158730e-05, 2.755731922398589e-06,
            2.755731922398589e-07, 2.505210838544172e-08, 2.087675698786810e-09,
            1.605904383682161e-10, 1.147074559772973e-11, 7.647163731819816e-13,
            4.779477332387385e-14, 2.811457254345521e-15, 1.561920696858623e-16,
            8.220635246624330e-18, 4.110317623312165e-19, 1.957294106339126e-20,
            8.896791392450574e-22, 3.868170170630684e-23, 1.611737571096118e-24,
            6.446950284384474e-26, 2.479596263224797e-27, 9.183689863795546e-29,
            3.279889237069838e-30, 1.130996288644772e-31, 3.769987628815905e-33,
            1.216125041553518e-34, 3.800390754854744e-36, 1.151633562077195e-37,
            3.387157535521162e-39, 9.677592958631890e-41, 2.688220266286636e-42,
            7.265460179153071e-44, 1.911963205040282e-45, 4.902469756513544e-47,
            1.225617439128386e-48, 2.989310827142405e-50, 7.117406731291439e-52,
            1.655210867742195e-53, 3.761842881232262e-55, 8.359650847182804e-57,
            1.817315401561479e-58, 3.866628513960594e-60, 8.055476070751238e-62,
            1.643974708316579e-63, 3.287949416633158e-65
    };

    public boolean is_close(double a, double b, double eps) {
        return Math.abs(a - b) < eps;
    }

    public boolean is_close(double a, double b) {
        return is_close(a, b, epsilon);
    }

    public boolean is_close(Complex a, Complex b, double eps) {
        return is_close(a.getReal(), b.getReal(), eps) && is_close(a.getImaginary(), b.getImaginary(), eps);
    }

    public boolean is_close(Complex a, Complex b) {
        return is_close(a, b, epsilon);
    }

    public boolean is_even(long n) {
        return n % 2 == 0;
    }

    public Complex clog(Complex z) {
        return z.log();
    }

    private final int n;

    public PolyLog(int n) {
        this.n = n;
    }

    public abstract double polylog(double x);

    public abstract double polylog(int n, double x);

    public abstract Complex polylog(Complex x);

    public abstract Complex polylog(int n, Complex x);


}
