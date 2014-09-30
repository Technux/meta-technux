SUMMARY = "IRC bot written in Python"
SECTION = "console/utils"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e8c1458438ead3c34974bc0be3a03ed6"

SRCREV = "bd42fabd919ed572325806e12a37024787a76793"
PE = "1"
PV = "0.1+git${SRCPV}"

SRC_URI = " \
	git://github.com/Technux/technuxbot.git;branch=master \
	file://technuxbot.init \
	"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "python python-argparse python-modules"

inherit update-rc.d

# TODO: but it should not run as root
INITSCRIPT_NAME = "technuxbot"
INITSCRIPT_PARAMS = "start 99 3 5 . stop 99 0 6 ."

# TODO: install it like other python modules
# using setuptools or similar
do_install() {
	install -d -m 0755 ${D}${sysconfdir}

	install -m 0644 ${S}/conf/bot.conf ${D}${sysconfdir}/technuxbot.conf

	install -d -m 0755 ${D}${sysconfdir}/init.d
	install -m 0544 ${WORKDIR}/technuxbot.init ${D}${sysconfdir}/init.d/technuxbot

	install -d -m 0755 ${D}${bindir}
	install -m 0400 ${S}/redmine_interface.py ${D}${bindir}
	install -m 0500 ${S}/ircbot.py ${D}${bindir}
}
