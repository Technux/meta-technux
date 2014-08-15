meta-technux
============
This layer contains Technux additions, it depends on:

URI: https://github.com/Technux/poky
branch: technux (or technux-dev for development purpose)
revision: HEAD


Supported board types
=====================
* qemux86
* qemux86-64
* raspberrypi
  - Depends on meta-raspberrypi
* technux-rpi
  - Depends on meta-raspberrypi
  - How to use it:
    1. Besides meta-technux you must also
       add meta-raspberrypi to bblayers.conf
    2. Set MACHINE to technux-rpi in local.conf
    3. bitbake technux-rpi-image
    4. Use generated sdimg (same description as in
       meta-raspberrypi)


Contributions
=============
Either send a 'git format-patch' to support@technux.se or become a member of
technux (see http://www.technux.se/Support/).
