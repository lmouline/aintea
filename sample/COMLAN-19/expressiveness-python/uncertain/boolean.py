import openturns as ot


class UBoolean:
    """
    Wrapper class of ot.Bernoulli to enable boolean operator
    """

    def __init__(self, confidence=ot.Bernoulli()):
        self.confidence = confidence

    def __str__(self):
        return "UBoolean(" + str(self.confidence.getP()) + ")"

    def __add__(self, other):
        if isinstance(other, UBoolean):
            return UBoolean(ot.Bernoulli(self.confidence.getP() * other.confidence.getP()))
        return NotImplemented

    def __or__(self, other):
        if isinstance(other, UBoolean):
            return UBoolean(ot.Bernoulli(self.confidence.getP() * other.confidence.getP()))
        return NotImplemented

    def not_op(self):
        return UBoolean(ot.Bernoulli(1 - self.confidence.getP()))

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

