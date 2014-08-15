# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

# Set default relase name to Technux
RNAME = "Technux"

IMAGE_FEATURES += "ssh-server-dropbear"

ROOTFS_POSTPROCESS_COMMAND += " generate_rel_file ; "

generate_rel_file() {
    IMAGE_REL_FILE="${IMAGE_ROOTFS}${sysconfdir}/technux-release"
    echo "${RNAME} release version" > ${IMAGE_REL_FILE}
    echo "Image: ${IMAGE_NAME}" >> ${IMAGE_REL_FILE}
    echo "Build date: ${DATETIME}" >> ${IMAGE_REL_FILE}

    chmod 0444 ${IMAGE_REL_FILE}
}
