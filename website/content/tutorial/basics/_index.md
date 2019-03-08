---
title: "Basics"
date: 2019-02-27
lastmod: 2019-03-05
draft: false
---

<div class="warning">
  <strong>Warning!</strong> Due to <a href="https://github.com/lmouline/uscript/issues/1">Issue 1</a>, the import to the uscript lib should be added to any script: <pre>import uscript.lang.*</pre>
</div>

In this tutorial, we will go trhough all the functionalities offer by the language.
All the final code is accessible on [GitHub](https://github.com/lmouline/uscript/tree/master/sample/tutorial/basics)



# Hellow World

In our language, the `print` function allow to write to the output stream.

```
package basics

void main() {
    print("Hello world!");
}
```

# Primitive datatypes

## Certain types
In our language, the certain types manage by our language are: `byte`, `short`, `int`, `long`, `float`, `double`, `bool`, `char`, and `string`.

```
package basics

void main() {
    byte b = 5;
    short s = 8;
    int i = 10;
    long l = 100L;
    float f = 0.8;
    double d = 10.8;
    bool b = true;
    char c = 'c';
    string str = "A String";
}
```

We support the different arithmetic operators for all the numeric types: addition, subtraction, multiplication and division.

```
package basics

void main() {
  int i1 = 90;
  int i2 = 45;

  int i3 = i1 + i2;
  int i4 = i1 - i2;
  int i5 = i1 * i2;
  int i6 = i1 / i2;
}
```

Same for boolean operation: and, or and not.

```
package basics

void main() {
  bool b1 = true;
  bool b2 = false;

  bool b3 = b1 && b2;
  bool b4 = b1 || b2;
  bool b5 = !b1;
}
```

## Uncertain types
In our language, we implement five different probability distribution to represent the uncertainty: 

  - [Bernoulli](https://en.wikipedia.org/wiki/Bernoulli_distribution) for uncertain boolean
  - [Gaussian](https://en.wikipedia.org/wiki/Normal_distribution), [Rayleigh](https://en.wikipedia.org/wiki/Rayleigh_distribution), [Binomial](https://en.wikipedia.org/wiki/Binomial_distribution) and [Dirac delta function](https://en.wikipedia.org/wiki/Dirac_delta_function) for uncertain numbers.

The following table the mapping between distributions and data type.

| Data type | Gaussian | Rayleigh | binomial| Dirac| Bernoulli|
|---|---|---|---|---|---|
| **float**| &#10003;| &#10003;|| &#10003;||
| **double**| &#10003;| &#10003;|| &#10003;||
| **byte**|| |  &#10003;| &#10003;||
| **short**|| |  &#10003;| &#10003;||
| **integer**|| |  &#10003;| &#10003; ||
| **long**|| |  &#10003;| &#10003; ||
| **boolean**|| |  |  |&#10003;|

```
package basics

void main() {
    Bernoulli<bool> b = new Bernoulli<bool>(true, 0.5);

    Gaussian<float> gf = new Gaussian<float>(0.5, 0.8);
    Gaussian<double> gd = new Gaussian<double>(0.5, 0.8);

    Rayleigh<float> rf = new Rayleigh<float>(0.5, 0.8);
    Rayleigh<double> rd = new Rayleigh<double>(0.5, 0.8);

    Binomial<byte> bb = new Binomial<byte>(9, 5);
    Binomial<short> bs = new Binomial<short>(9, 5);
    Binomial<int> bi = new Binomial<int>(9, 5);
    Binomial<long> bl = new Binomial<long>(9, 5);

    DiracDeltaFct<float> df = new DiracDeltaFct<float>(0.5, 0.8);
    DiracDeltaFct<double> dd = new DiracDeltaFct<double>(0.5, 0.8);
    DiracDeltaFct<byte> db = new DiracDeltaFct<byte>(9, 5);
    DiracDeltaFct<short> ds = new DiracDeltaFct<short>(9, 5);
    DiracDeltaFct<int> di = new DiracDeltaFct<int>(9, 5);
    DiracDeltaFct<long> dl = new DiracDeltaFct<long>(9, 5);
}
```

On these new data types, we can apply usual operators as on certian types:
  - arithmetic operators on uncertain numeric (Gaussian, Rayleigh, Binomial, Dirac)
  - boolean operator on uncertain boolean (Bernoulli)






