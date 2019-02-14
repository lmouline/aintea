import smartGrid as sg
import uncertain.boolean as ubool
import uncertain.number as unumber

if __name__ == '__main__':

    fuse1 = sg.Fuse(is_closed=ubool.UBoolean(True, 1))
    fuse2 = sg.Fuse(is_closed=ubool.UBoolean(True, 1))
    fuse3 = sg.Fuse(is_closed=ubool.UBoolean(True, 1))

    cable1 = sg.Cable()
    cable1.load = unumber.Dirac(10, 0.8)
    fuse1.cable = cable1

    cable2 = sg.Cable()
    cable2.load = unumber.Dirac(15, 0.8)
    fuse2.cable = cable2

    cable3 = sg.Cable()
    cable3.load = unumber.Dirac(15, 0.8)
    fuse3.cable = cable3

    substation = sg.Substation(unumber.UNumber(), fuse1, fuse2, fuse3)
    sg.compute_load(substation)
    print(substation)




