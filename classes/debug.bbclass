do_configure_prepend() {
    filesextra="${@d.getVar("FILESEXTRAPATHS",True)}"
    filespath="${@d.getVar("FILESPATH",True)}"
    rm -f /tmp/filesextra.txt
    rm -f /tmp/filespath.txt
    echo $filesextra > /tmp/filesextra.txt
    echo $filespath > /tmp/filespath.txt
}
