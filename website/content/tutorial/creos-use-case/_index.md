---
title: "Creos use case"
date: 2019-02-27
lastmod: 2019-03-05
draft: false
---

<div class="warning">
  <strong>Warning!</strong> Due to <a href="https://github.com/lmouline/uscript/issues/1">Issue 1</a>, the import to the uscript lib should be added to any script: <pre>import uscript.lang.*</pre>
</div>

In this tutorial we will see how to implement a simplified version of a load apprximation script.
The final code of this tutorial can be accessible on [GitHub](https://github.com/lmouline/uscript/tree/master/sample/tutorial/creos).


# Introduction

 - Load computation of the different situation

 **Situation 1**:

![](/img/tutorial/creos/situation1.svg)


# Step 1 - Definition of the classes

`smartgrid.uscript` file:
```
package smartgrid

import uscript.lang.*

class Entity {
  Fuse[] fuses;
  Gaussian<double> load;
}

class Substation extends Entity {}
class Cabinet extends Entity {}
class DeadEndCabinet extends Entity {}

class Fuse {
  Bernoulli<bool> isClosed;
  Cable cable;
  Entity entity;
}

class Cable{
  Gaussian<double> load;
}
```

In another file, we can execute a simple Runner:
