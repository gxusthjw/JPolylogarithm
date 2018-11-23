#!/usr/bin/env python

'''
Author: John D. Anderson
Email: jander43@vols.utk.edu
Usage: stirling -n <integer>
Description:
    Simple module for generating a 2D list of stirling numbers from [0 to n]
'''

# libraries
import sys


# functions
def gen_stirling(n):
    '''
    Function to create Stirling numbers
    '''
    # initialize [n k] = [0 0] to 1
    s = [[1]]

    # building stirling triangle
    for i in range(1, n + 1):
        # initialize k=0 partition to 0
        r = [0]
        for k in range(1, i):
            r.append((i - 1) * s[i - 1][k] + s[i - 1][k - 1])
        r.append(1)
        s.append(r[:])
    # exit
    return s


def print_stirling(s):
    '''
    Function to print out stirling numbers from 2D list
    '''
    # iterate list
    for ls in s:
        print(ls)
    return


# executable
if __name__ == '__main__':
    if len(sys.argv) > 1:

        if sys.argv[1] == '-n':
            print_stirling(gen_stirling(int(sys.argv[2])))

    else:
        sys.exit('\nusage: stirling -n <integer>\n')
