import openturns as ot


class UBoolean:
    """
    Simplified version of an uncertain boolean.
    The boolean operators works only for independent and non-disjoint variables
    """

    def __init__(self, value=False, confidence=0.):
        self.value = value

        if self.value:
            self.confidence = ot.Bernoulli(confidence)
        else:
            self.confidence = ot.Bernoulli(1-confidence)

    def __str__(self):
        if self.value:
            confidence = self.confidence.getP()
        else:
            confidence = 1 - self.confidence.getP()

        return "UBoolean(value=" + str(self.value) + ", confidence=" + str(confidence) + ")"

    def and_op(self, other):
        if isinstance(other, UBoolean):
            return UBoolean(self.value and other.value, self.confidence.getP() * other.confidence.getP())
        return NotImplemented

    def or_op(self, other):
        if isinstance(other, UBoolean):
            return UBoolean(self.value and other.value, self.confidence.getP() * other.confidence.getP())
        return NotImplemented

    def not_op(self):
        return UBoolean(not self.value, self.confidence.getP())

    def value_with_confidence(self, threshold):
        if self.exist(threshold):
            p = self.confidence.getP()
            if p >= threshold:
                return True
            elif p < threshold:
                return False
        raise RuntimeError("No value exist for " + str(self) + "with a confidence of " + str(threshold))

    def exist(self, threshold):
        if isinstance(threshold, (int, float)):
            p = self.confidence.getP()
            return p >= threshold or (1-p) >= threshold

