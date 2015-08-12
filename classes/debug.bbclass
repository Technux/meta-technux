# Technux debug class

MACHINEOVERRIDES .= ":technux-debug"

print_overrides() {
    echo ${OVERRIDES}
    echo ${MACHINEOVERRIDES}
    echo ${FILESOVERRIDES}
    echo ""
}

do_configure_prepend() {
    filesextra="${@d.getVar("FILESEXTRAPATHS",True)}"
    filespath="${@d.getVar("FILESPATH",True)}"

    echo FILESEXTRAPATHS
    echo $filesextra

    echo FILESPATH
    echo $filespath
}

# Printout important OVERRIDES.
# Also printout the order in which the overrides are executed
do_install_append() {
    echo "===================="
    echo "DEFAULT"
    print_overrides
}

do_install_append_raspberrypi() {
    echo "===================="
    echo "raspberrypi"
    print_overrides
}

do_install_append_technux-rpi() {
    echo "===================="
    echo "technux-rpi"
    print_overrides
}

do_install_append_armv6() {
    echo "===================="
    echo "armv6"
    print_overrides
}

do_install_append_x86(){
    echo "===================="
    echo "x86"
    print_overrides
}

do_install_append_technux-debug(){
    echo "===================="
    echo "technux-debug"
    print_overrides
}

do_install_append_${MACHINE}() {
    echo "===================="
    echo "machine = ${MACHINE}"
    print_overrides
}
