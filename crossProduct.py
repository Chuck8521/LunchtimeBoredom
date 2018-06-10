# -*- coding: utf-8 -*-
"""
Created on Sun Jun 10 15:22:17 2018

@author: Supreme
"""

#v is first vector and w is second - both have THREE elements. The symbol between boxes for cross product is an X.

#Input for both should be num,num,num     -   ex. 5,3,6
v = list(map(int,input().split(",")))
w = list(map(int,input().split(",")))

x = v[1]*w[2] - v[2]*w[1]
y = v[2]*w[0] - v[0]*w[2]
z = v[0]*w[1] - v[1]*w[0]

out = "(" + str(x) + "," + str(y) + "," + str(z) + ")"
print(out)


