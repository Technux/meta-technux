FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "technux-dev"
SRC_URI = "git://github.com/Technux/linux.git;protocol=http;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"

LINUX_VERSION ?= "3.14"
LINUX_VERSION_EXTENSION = "-technux-dev"


SRCREV="2e0198e22d676a332ec1319073e334c859953a96"

PR = "r4"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
#COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE = "qemux86|qemux86-64"
