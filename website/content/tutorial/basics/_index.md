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

```
package basics

void main() {
    print("Hello world!");
}
```

# String concatenation

```
package basics

void main() {
    String hello = "hello";
    String name = "Jean"
    double age = 5;
    print("Hello world! " + 2019);
}
```