SUMMARY = "Python HTTP for Humans"
DESCRIPTION = "Requests is an Apache2 Licensed HTTP library, written in Python, for human beings. \
Most existing Python modules for sending HTTP requests are extremely verbose and \
cumbersome. Python's builtin urllib2 module provides most of the HTTP capabilities \
you should need, but the api is thoroughly broken. It requires an enormous amount \
of work (even method overrides) to perform the simplest of tasks. \
Things shouldn't be this way. Not in Python. \
Requests allow you to send HTTP/1.1 requests. You can add headers, form data, \
multipart files, and parameters with simple Python dictionaries, and access \
the response data in the same way. It's powered by httplib and urllib3, \
but it does all the hard work and crazy hacks for you."

HOMEPAGE = "https://pypi.python.org/pypi/requests"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=c7869e52c8275537186de35e3cd5f9ec \
    "

SRC_URI = "\
    https://pypi.python.org/packages/source/r/requests/requests-${PV}.tar.gz;name=archive \
    "
SRC_URI[archive.md5sum] = "c270eb5551a02e8ab7a4cbb83e22af2e"
SRC_URI[archive.sha256sum] = "7b7735efd3b1e2323dc9fcef060b380d05f5f18bd0f247f5e9e74a628279de66"

S = "${WORKDIR}/requests-${PV}"

inherit setuptools

BBCLASSEXTEND = "native"
