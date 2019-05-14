from uncertainties import ufloat
from random import uniform
from math import sqrt

# Constants that cn be modified to get different results.
# Current values have been arbitrary chosen
NB_CABLES = 2
MIN_LOAD = 0
MAX_LOAD = 150


class SmartGrid:
    def __init__(self):
        self.cables = []

    def compute_avg_load(self):
        sum_load = 0

        for c in self.cables:
            try:
                sum_load += c.load
            except AttributeError:
                raise AttributeError("%s is not an instance of Cable class but a instance of %s" % (c, type(c)))

        return sum_load / len(self.cables)


class Cable:

    def __init__(self, p_id, p_load=ufloat(0, 0)):
        self.id = p_id
        self.load = p_load

    def __str__(self):
        return "Cable(%s, %s)" % (self.id, self.load)


def main():
    grid = SmartGrid()

    for i in range(0, NB_CABLES):
        load = uniform(MIN_LOAD, MAX_LOAD)
        max_deviation = sqrt(load / 2)
        deviation = uniform(0, max_deviation)
        cable = Cable(i, ufloat(load, deviation))
        grid.cables.append(cable)

    for c in grid.cables:
        print("%s" % c)

    grid_avg_load = grid.compute_avg_load()
    print("Gid load is equal to %s" % grid_avg_load)


if __name__ == "__main__":
    main()
