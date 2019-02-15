from __future__ import print_function
import openturns as ot
from openturns.viewer import View
import sys

distribution1 = ot.Normal(1, 2)
distribution2 = ot.Normal(10, 3)
distribution3 = distribution1 + distribution2

print(distribution1)
print(distribution2)
print(distribution3)

# print(str(distribution == distribution1))
# graph = distribution.drawPDF()
# graph.setLegends(['normal pdf'])
#
# ot.Max
#
# view = View(graph)
# view.save('curve.png', dpi=100)
# view.show()
