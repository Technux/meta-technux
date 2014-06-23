FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "technux-v3.14-dev"
SRC_URI = "git://github.com/Technux/linux.git;protocol=http;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"

LINUX_VERSION ?= "3.14"
LINUX_VERSION_EXTENSION ?= "-technux"


SRCREV="0c0f1ae493d6390001dd8ebb0d69befb9369de76"

PR = "r3"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
#COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE = "qemux86|qemux86-64"
