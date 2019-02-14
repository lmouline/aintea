import uncertain.boolean as ubool
import openturns as ot
import sys


class UNumber:
    """
    Simplified version of an uncertain number
    """

    def __init__(self, value=0, confidence=None):
        self.value = value
        self.confidence = confidence

    def __str__(self):
        return "UNumber(value=" + str(self.value) + ", confidence=" + str(self.confidence) + ")"

    def __gt__(self, other):
        if isinstance(other, (int, float)):
            return ubool.UBoolean(self.value > other,
                                  self.confidence.computeProbability(ot.Interval(other, sys.maxsize)))

        return NotImplemented


class Dirac:
    """
    Dirac delta function
    Required as the one of OpenTurns do not support scaling operation
    """
    def __init__(self, value=0, confidence=1):
        self.value = value
        self.confidence = confidence

    def __str__(self):
        return "Dirac(value=" + str(self.value) + ", confidence=" + str(self.confidence) + ")"

    def __gt__(self, other):
        if isinstance(other, (int, float)):
            return ubool.UBoolean(self.value > other, self.confidence)

        raise NotImplementedError("Operator '>' is not implemented for type " + str(type(other)))

    def __mul__(self, other):
        if isinstance(other, (int, float)):
            return Dirac(self.value, self.confidence*other)

        raise NotImplementedError("Operator '>' is not implemented for type " + str(type(other)))

    def __add__(self, other):
        if isinstance(other, Dirac):
            return Dirac(self.value + other.value, self.confidence * other.confidence)

        raise NotImplementedError("Operator '>' is not implemented for type " + str(type(other)))
