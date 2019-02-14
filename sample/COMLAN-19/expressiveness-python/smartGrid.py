import uncertain.boolean as ubool
import uncertain.number as unumber
import openturns as ot


class Substation:
    def __init__(self, load=unumber.UNumber(), *fuses):
        self.load = load
        self.fuses = fuses

    def __str__(self):
        fuses_str = [str(f) for f in self.fuses]
        return "Substation(load=" + str(self.load) + ", fuses=" + ', '.join(fuses_str) + ")"

    def is_overloaded(self):
        ub = self.load > 20

        if ub.exist(90):
            if ub.value_with_confidence(90):
                return True
        return False

    def is_disconnected(self):
        if len(self.fuses) == 0:
            return ubool.UBoolean(True, 1)
        else:
            is_conn = self.fuses[0].isClosed

        for fuse in self.fuses[1:]:
            is_conn = is_conn.or_op(fuse.isClosed)

        return is_conn.not_op()


class Cabinet(Substation):
    pass


class DeadEndCabinet(Cabinet):
    pass


class Fuse:
    def __init__(self, cable=None, is_closed=ubool.UBoolean(True, ot.Bernoulli(1))):
        self.cable = cable
        self.isClosed = is_closed

    def __str__(self):
        return "Fuse(isClosed=" + str(self.isClosed) + ")"


class Cable:
    def __init__(self, start_point=None, end_point=None, load=unumber.UNumber(), capacity=100, *meters):
        self.startPoint = start_point
        self.endPoint = end_point
        self.meters = meters
        self.load = load
        self.capacity = capacity

    def get_consumption(self):
        consumption = 0
        for meter in self.meters:
            consumption += meter.consumption
        return consumption


class SmartMeter:
    def __init__(self, consumption=0):
        self.consumption = consumption


def compute_load_no_cable(substation):
    if not isinstance(substation, Substation):
        raise TypeError('Argument of loadComputer should be an instance of Substation. Actual:' + type(substation))

    no_cable_conn = ubool.UBoolean()
    if len(substation.fuses) > 0:
        no_cable_conn = substation.fuses[0].isClosed
    else:
        substation.load = ot.Dirac(0)

    for fuse in substation.fuses[1:]:
        no_cable_conn = no_cable_conn.and_op(fuse.isClosed)

    substation.load = unumber.Dirac(confidence=no_cable_conn.confidence.getP())


def compute_load(substation):
    if not isinstance(substation, Substation):
        raise TypeError('Argument of loadComputer should be an instance of Substation. Actual:' + type(substation))

    is_disco = substation.is_disconnected()
    if is_disco.exist(0.95) and is_disco.value_with_confidence(0.95):
        return compute_load_no_cable(substation)

    load = unumber.Dirac()
    for fuse in substation.fuses:
            load = load + (fuse.cable.load*fuse.isClosed.confidence.getP())

    substation.load = load




