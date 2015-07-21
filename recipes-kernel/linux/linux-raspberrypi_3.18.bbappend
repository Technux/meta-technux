inherit technux-rpi-common

# task 'kernel_configme' fails unless pointing at a defconfig
# that exists in the rpi branch in kernel src tree
KERNEL_DEFCONFIG_technux-rpi = "bcmrpi_defconfig"

CMDLINE_technux-rpi = "dwc_otg.lpm_enable=0 console=ttyAMA0,115200 kgdboc=ttyAMA0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait"
