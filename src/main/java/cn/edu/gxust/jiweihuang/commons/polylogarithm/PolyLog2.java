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
package cn.edu.gxust.jiweihuang.commons.polylogarithm;

import org.hipparchus.complex.Complex;

public class PolyLog2 extends PolyLogBase {
    /**
     * Clausen function
     */
    public static double Cl2(double x) {
        while (x >= 2 * Math.PI) {
            return x -= 2 * Math.PI;
        }
        while (x < 0.0) {
            x += 2 * Math.PI;
        }
        if (Math.abs(x) < EPSILON ||
                Math.abs(x - Math.PI) < EPSILON ||
                Math.abs(x - 2 * Math.PI) < EPSILON) {
            return .0;
        }
        Complex t = (new Complex(0.0, 1.0)).multiply(x).exp();
        return Li2(t).getImaginary();
    }

    public static double Li2(double x) {
        final double HF = 0.5;
        final double PI2 = Math.PI * Math.PI;
        final double PI3 = PI2 / 3;
        final double PI6 = PI2 / 6;
        final double PI12 = PI2 / 12;
        final double[] C = new double[]{
                0.42996693560813697, 0.40975987533077105,
                -0.01858843665014592, 0.00145751084062268, -0.00014304184442340,
                0.00001588415541880, -0.00000190784959387, 0.00000024195180854,
                -0.00000003193341274, 0.00000000434545063, -0.00000000060578480,
                0.00000000008612098, -0.00000000001244332, 0.00000000000182256,
                -0.00000000000027007, 0.00000000000004042, -0.00000000000000610,
                0.00000000000000093, -0.00000000000000014, 0.00000000000000002
        };

        double T, H, Y, S, A, ALFA, B1, B2, B0;

        if (x == 1) {
            H = PI6;
        } else if (x == -1) {
            H = -PI12;
        } else {
            T = -x;
            if (T <= -2) {
                Y = -1 / (1 + T);
                S = 1;
                B1 = Math.log(-T);
                B2 = Math.log(1 + 1 / T);
                A = -PI3 + HF * (B1 * B1 - B2 * B2);
            } else if (T < -1) {
                Y = -1 - T;
                S = -1;
                A = Math.log(-T);
                A = -PI6 + A * (A + Math.log(1 + 1 / T));
            } else if (T <= -0.5) {
                Y = -(1 + T) / T;
                S = 1;
                A = Math.log(-T);
                A = -PI6 + A * (-HF * A + Math.log(1 + T));
            } else if (T < 0) {
                Y = -T / (1 + T);
                S = -1;
                B1 = Math.log(1 + T);
                A = HF * B1 * B1;
            } else if (T <= 1) {
                Y = T;
                S = 1;
                A = 0;
            } else {
                Y = 1 / T;
                S = -1;
                B1 = Math.log(T);
                A = PI6 + HF * B1 * B1;
            }
            H = Y + Y - 1;
            ALFA = H + H;
            B0 = 0;
            B1 = 0;
            B2 = 0;
            for (int i = 19; i >= 0; i--) {
                B0 = C[i] + ALFA * B1 - B2;
                B2 = B1;
                B1 = B0;
            }
            H = -(S * (B0 - H * B2) + A);
        }
        return H;
    }

    public static Complex Li2(Complex x) {
        final double[] bf = new double[]{
                -1. / 4.,
                +1. / 36.,
                -1. / 3600.,
                +1. / 211680.,
                -1. / 10886400.,
                +1. / 526901760.,
                -4.064761645144226e-11,
                +8.921691020456453e-13,
                -1.993929586072108e-14,
                +4.518980029619918e-16
        };

        final double rz = x.getReal();
        final double iz = x.getImaginary();
        final double az = x.abs();

        // special cases
        if (iz == 0.) {
            if (rz <= 1.)
                return new Complex(Li2(rz), .0);
            else // (rz > 1.)
                return new Complex(Li2(rz), -Math.PI * Math.log(rz));
        } else if (az < EPSILON) {
            return x;
        }

        Complex cy, cz;
        int jsgn, ipi12;

        // transformation to |z|<1, Re(z)<=0.5
        if (rz <= 0.5) {
            if (az > 1.) {
                cy = (x.negate().log().multiply(x.negate().log())).multiply(-0.5);
                cz = x.pow(-1).negate().add(1.0).log().negate();
                jsgn = -1;
                ipi12 = -2;
            } else { // (az <= 1.)
                cy = new Complex(.0, .0);
                cz = x.negate().add(1.0).log();
                jsgn = 1;
                ipi12 = 0;
            }
        } else { // rz > 0.5
            if (az <= Math.sqrt(2 * rz)) {
                cz = x.log().negate();
                cy = x.negate().add(1.0).log().multiply(cz);
                jsgn = -1;
                ipi12 = 2;
            } else { // (az > sqrt(2*rz))
                cy = x.negate().log().multiply(x.negate().log()).multiply(-0.5);
                cz = x.pow(-1.0).negate().add(1.0).log().negate();
                jsgn = -1;
                ipi12 = -2;
            }
        }

        // the dilogarithm
        final Complex cz2 = cz.multiply(cz);
        final Complex sum = cz2.multiply(bf[9]).add(bf[8]).multiply(cz2).add(bf[7]).multiply(cz2).add(bf[6]).multiply(cz2).add(bf[5]).multiply(cz2).add(bf[4]).multiply(cz2).add(bf[3]).multiply(cz2).add(bf[2]).multiply(cz2).add(bf[1]).multiply(cz).add(bf[0]).multiply(cz2).add(cz);
        return sum.multiply(jsgn).add(cy).add(ipi12 * Math.PI * Math.PI / 12.0);
    }
}
