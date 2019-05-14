from scipy.stats.distributions import rv_frozen
from scipy.stats import norm
from random import uniform
from math import sqrt, pow
from numbers import Number

# Constants that cn be modified to get different results.
# Current values have been arbitrary chosen
NB_CABLES = 2
MIN_LOAD = 0
MAX_LOAD = 150


def check_param(param, name):
    if not (isinstance(param, rv_frozen)) and not (isinstance(param, Number)):
        raise TypeError("%s parameter should be a instance of "
                        "scipy.stats.distributions.scipy.stats.distributions.rv_frozen or a number."
                        "Actual type: %s" % (name,type(param)))


def add_gaussian(g1, g2):
    check_param(g1, "g1")
    check_param(g2, "g2")

    if isinstance(g1, Number):
        return norm(g1 + g2.mean(), g2.std())
    elif isinstance(g2, Number):
        return norm(g1.mean() + g2, g1.std())
    else:
        return norm(g1.mean() + g2.mean(), sqrt(g1.var() + g2.var()))


def div_gaussian(g1, g2):
    check_param(g1, "g1")
    check_param(g2, "g2")

    if isinstance(g1, Number):
        value = (g1 / g2.mean()) + (g1 * g2.var()) / (pow(g2.mean(), 3))
        variance = (pow(g1, 2) * g2.var()) / (pow(g2.mean(), 4))
    elif isinstance(g2, Number):
        value = g1.mean() / g2
        variance = g1.var() / g2
    else:
        value = (g1.mean / g2.mean) + (g1.mean * g2.variance) / (pow(g2.mean, 3))
        variance = (g1.variance / g2.mean) + (pow(g1.mean, 2) * g2.variance) / (pow(g2.mean, 4))

    return norm(value, sqrt(variance))


class SmartGrid:
    def __init__(self):
        self.cables = []

    def compute_avg_load(self):
        sum_load = 0

        for c in self.cables:
            try:
                sum_load = add_gaussian(sum_load, c.load)
            except AttributeError:
                raise AttributeError("%s is not an instance of Cable class but a instance of %s" % (c, type(c)))

        return div_gaussian(sum_load, len(self.cables))


class Cable:

    def __init__(self, p_id, p_load=norm(0, 0)):
        self.id = p_id
        self.load = p_load

    def __str__(self):
        return "Cable(%s, %s, %s)" % (self.id, self.load.mean(), self.load.var())


def main():
    grid = SmartGrid()

    for i in range(0, NB_CABLES):
        load = uniform(MIN_LOAD, MAX_LOAD)
        max_deviation = sqrt(load / 2)
        deviation = uniform(0, max_deviation)
        cable = Cable(i, norm(load, deviation))
        grid.cables.append(cable)

    for c in grid.cables:
        print("%s" % c)

    grid_avg_load = grid.compute_avg_load()
    print("Gid load is equal to %s +/- %s" % (grid_avg_load.mean(), grid_avg_load.std()))


if __name__ == "__main__":
    main()
