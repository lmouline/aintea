from __future__ import print_function
import openturns as ot
from openturns.viewer import View
import sys

distribution = ot.Normal()
# distribution1 = ot.Normal(10, 0.51)
# print(str(distribution == distribution1))

print(distribution.computeProbability(ot.Interval(0, 0)))


# graph = distribution.drawPDF()
# graph.setLegends(['normal pdf'])
#
# ot.Max
#
# view = View(graph)
# view.save('curve.png', dpi=100)
# view.show()
