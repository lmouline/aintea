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