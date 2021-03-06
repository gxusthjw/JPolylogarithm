// ====================================================================
// This file is part of Polylogarithm.
//
// Polylogarithm is licenced under the GNU Lesser General Public
// License (GNU LGPL) version 3.
// ====================================================================

#pragma once
#include <complex>

namespace polylogarithm {

/// Clausen function with n=3
double Cl3(double);

/// complex polylogarithm with n=3 (trilogarithm)
std::complex<double> Li3(const std::complex<double>&);

} // namespace polylogarithm
