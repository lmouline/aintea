import smartGrid as sg
import uncertain.boolean as ubool
import openturns as ot

if __name__ == '__main__':

    fuse1 = sg.Fuse(ubool.UBoolean(ot.Bernoulli(1)))
    fuse2 = sg.Fuse(ubool.UBoolean(ot.Bernoulli(1)))
    fuse3 = sg.Fuse(ubool.UBoolean(ot.Bernoulli(1)))

    cable1 = sg.Cable(ot.Normal(10, 0.8))
    fuse1.cable = cable1

    cable2 = sg.Cable(ot.Normal(10, 0.8))
    fuse2.cable = cable2

    cable3 = sg.Cable(ot.Normal(10, 0.8))
    fuse3.cable = cable3

    substation = sg.Substation(fuse1, fuse2, fuse3)
    sg.compute_load(substation)
    print(substation)




