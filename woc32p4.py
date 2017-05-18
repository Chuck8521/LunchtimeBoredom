#!/bin/python3

import sys

def geometricTrick(s):
    # Complete this function
    possA = []
    possB = []
    possC = []
    for index, letter in enumerate(s):
        if letter == 'a':
            possA.append(index + 1)
        if letter == 'b':
            possB.append(index + 1)
        if letter == 'c':
            possC.append(index + 1)
    perfSquares = [i * i for i in range(1,775) if i - 1 in possB]
    poss

n = int(input().strip())
s = input().strip()
result = geometricTrick(s)
print(result)
