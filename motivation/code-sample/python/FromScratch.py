from numbers import Number
from math import sqrt, pow
from random import uniform

# Constants that cn be modified to get different results.
# Current values have been arbitrary chosen
NB_CABLES = 2
MIN_LOAD = 0
MAX_LOAD = 150


class UNumber:
    def __init__(self, mean=0., variance=0.):
        self.mean = mean
        self.variance = variance

    def __add__(self, other):
        if not(isinstance(other, UNumber)) and not(isinstance(other, Number)):
            raise TypeError("UNumber can only be added with another UNumber or a Number."
                            "Actual type: %s" % type(other))

        if isinstance(other, Number):
            other = UNumber(other, 0)

        return UNumber(self.mean + other.mean, self.variance + other.variance)

    def __div__(self, other):
        if not(isinstance(other, UNumber)) and not(isinstance(other, Number)):
            raise TypeError("UNumber can only be added with another UNumber or a Number."
                            "Actual type: %s" % type(other))

        if isinstance(other, Number):
            other = UNumber(other, 0)

        value = (self.mean / other.mean) + (self.mean * other.variance) / (pow(other.mean, 3))
        variance = (self.variance / other.mean) + (pow(self.mean, 2) * other.variance) / (pow(other.mean, 4))

        return UNumber(value, variance)

    def __str__(self):
        return "UNumber(%s, %s)" % (self.mean, self.variance)


class SmartGrid:
    def __init__(self):
        self.cables = []

    def compute_avg_load(self):
        sum_load = UNumber(0,0)

        for c in self.cables:
            try:
                sum_load += c.load
            except AttributeError:
                raise AttributeError("%s is not an instance of Cable class but a instance of %s" % (c, type(c)))

        return sum_load / len(self.cables)


class Cable:

    def __init__(self, p_id, p_load=UNumber(0, 0)):
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
        cable = Cable(i, UNumber(load, deviation))
        grid.cables.append(cable)

    for c in grid.cables:
        print("%s" % c)

    grid_avg_load = grid.compute_avg_load()
    print("Gid load is equal to %s" % grid_avg_load)


if __name__ == "__main__":
    main()
