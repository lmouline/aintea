Ain'tea
---

[![Build Status](https://travis-ci.org/lmouline/uscript.svg?branch=master)](https://travis-ci.org/lmouline/uscript)

**Building...**

# Syntax description

# Constraint / Static semantics

- Class names should be unique
- Function names should be unique
- Mapping between uncertainty representation and data type:
    - {float, double} <-> {Gaussian, Rayleigh}
    - {short, integer, long} <-> binomial
    - {short, integer, long, float, double} <-> Dirac delta function
