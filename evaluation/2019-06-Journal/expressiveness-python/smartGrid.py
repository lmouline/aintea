import uncertain.boolean as ubool
import openturns as ot


class Substation:
    def __init__(self, *fuses):
        self.fuses = fuses

    def __str__(self):
        fuses_str = [str(f) for f in self.fuses]
        return "Substation(load=" + str(self.load) + ", fuses=" + ', '.join(fuses_str) + ")"

    def is_disconnected(self):
        if len(self.fuses) == 0:
            return ubool.UBoolean(True, 1)
        else:
            is_conn = self.fuses[0].isClosed

        for fuse in self.fuses[1:]:
            is_conn = is_conn | fuse.isClosed

        return is_conn.not_op()


class Fuse:
    def __init__(self, cable=None, is_closed=ubool.UBoolean(ot.Bernoulli(1))):
        self.cable = cable
        self.isClosed = is_closed

    def __str__(self):
        return "Fuse(isClosed=" + str(self.isClosed) + ")"


class Cable:
    def __init__(self, load):
        self.load = load


def compute_load_no_cable(substation):
    if not isinstance(substation, Substation):
        raise TypeError('Argument of loadComputer should be an instance of Substation. Actual:' + type(substation))

    if len(substation.fuses) > 0:
        no_cable_conn = substation.fuses[0].isClosed
    else:
        substation.load = ot.Normal(0, 0.001)
        return

    for fuse in substation.fuses[1:]:
        no_cable_conn = no_cable_conn & fuse.isClosed

    std = no_cable_conn.confidence.getStandardDeviation()[0]
    print(no_cable_conn.confidence.getP())
    if std == 0:
        std = 0.001
    substation.load = ot.Normal(0, std*std)


def compute_load(substation):
    if not isinstance(substation, Substation):
        raise TypeError('Argument of loadComputer should be an instance of Substation. Actual:' + type(substation))

    is_disco = substation.is_disconnected()
    if is_disco.exist(0.95) and is_disco.value_with_confidence(0.95):
        compute_load_no_cable(substation)
        return

    load = ot.Normal(0, 0.001)

    for fuse in substation.fuses:
        load = load + (fuse.cable.load*fuse.isClosed.confidence.getP())

    substation.load = load




