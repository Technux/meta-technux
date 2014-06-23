/******************************************************************************
 *
 *   Copyright (C) 2014  Technux. All rights reserved.
 *
 *   This program is free software;  you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY;  without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See
 *   the GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program;  if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 *****************************************************************************/

#include <linux/module.h>
#include <linux/moduleparam.h>
#include <linux/types.h>
#include <linux/kdev_t.h>
#include <linux/fs.h>

static int simulate_error = 0;
static int smartux_major = 0;
static int smartux_minor = 0;
static int smartux_debug = 0;
module_param(simulate_error, int, S_IRUGO);
module_param(smartux_major, int, S_IRUGO);
module_param(smartux_minor, int, S_IRUGO);
module_param(smartux_debug, int, S_IRUGO);

struct smartux_t
{
    dev_t smartux_dev;
};

static struct smartux_t smartux;


/*struct file_operations smartux_fops = {*/
/*    .owner = THIS_MODULE,*/
/*    .llseek = smartux_llseek,*/
/*    .read = smartux_read,*/
/*    .write = smartux_write,*/
/*    .ioctl = smartux_ioctl,*/
/*    .open = cull_open,*/
/*    .release = smartux_release,*/
/*};*/


int init_module(void)
{
    int ret = -ENODEV;

	printk("Loading smartux driver...\n");

    if (smartux_major) {
        smartux.smartux_dev = MKDEV(smartux_major, smartux_minor);
        ret = register_chrdev_region(smartux.smartux_dev, 1, "smartux");

    } else {
        ret = alloc_chrdev_region(&smartux.smartux_dev, smartux_minor,
                1, "smartux");
        smartux_major = MAJOR(smartux.smartux_dev);
    }

    if (ret < 0) {
        printk(KERN_WARNING "smartux: can't get major %d\n",
                smartux_major);
        goto handle_error;
    }

    if (simulate_error)
        goto handle_sim_error;

	return ret;

handle_error:
    unregister_chrdev_region(smartux.smartux_dev, 1);
    return ret;
handle_sim_error:
	printk("Simulate error = %d\n", simulate_error);
    return simulate_error;
}

void cleanup_module(void)
{
    unregister_chrdev_region(smartux.smartux_dev, 1);
	printk("smartux successfully unloaded\n");

}

MODULE_AUTHOR("Petter Mabacker");
MODULE_DESCRIPTION("monitoring and tracing the kernel");
MODULE_LICENSE("GPL");
