SUMMARY = "Library for communicating with a Redmine project management application"
DESCRIPTION = "Python Redmine is a library for communicating with a Redmine \
project management application. Redmine exposes some of it's data via REST API \
for which Python Redmine provides a simple but powerful Pythonic API inspired \
by a well-known Django ORM"
HOMEPAGE = "https://pypi.python.org/pypi/python-redmine"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://README.rst;beginline=107;endline=111;md5=973d87802555a547aa873fb51cb3e947 \
    file://LICENSE;md5=6e108d9ecd42dbf27e4463aff3a7831f \
    "

SRC_URI = "\
    https://pypi.python.org/packages/source/p/python-redmine/python-redmine-${PV}.tar.gz;name=archive \
    "
SRC_URI[archive.md5sum] = "0d2920afeca2d1995df3db8ed51e68b3"
SRC_URI[archive.sha256sum] = "4a257394d74d6e59060f74326d9b10f88ee7a8fa8f55b82e3919abe215b8e594"

inherit setuptools

RDEPENDS_${PN} += "python-requests"

BBCLASSEXTEND = "native"
