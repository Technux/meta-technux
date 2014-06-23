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
#include <linux/sched.h>
#include <linux/moduleparam.h>

static char *test_str = "default";
static int simulate_error  = 0;
module_param(simulate_error, int, S_IRUGO);
module_param(test_str, charp, S_IRUGO);

int init_module(void)
{
	printk("Technux (http://www.technux.se)!\n");
    printk(KERN_INFO "The process is \"%s\" (pid %i)\n",
            current->comm, current->pid);

    if(current->pid < 0 || simulate_error)
        goto handle_error;

	return 0;

handle_error:
	printk("Simulate error = %d\n", simulate_error);
    return simulate_error;
}

void cleanup_module(void)
{
	printk("Goodbye Cruel World!\n");

}

MODULE_AUTHOR("Petter Mabacker");
MODULE_DESCRIPTION("Just a dummy module...");
MODULE_LICENSE("GPL");
