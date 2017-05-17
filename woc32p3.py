#!/bin/python3

import sys


def circularWalk(n, s, t, r_0, g, seed, p):
    # Complete this function
    
    if s == t:
        return 0
    
    r = [r_0]
    for q in range(1,n):
        r.append(((r[q-1]*g)+seed) % p)
    
    visited = []
    currentPoints = [s]
    steps = 0
    #When t is in visited, stop
    while t not in currentPoints:
        
        if len(currentPoints) == 0:
            return -1
        
        newCurr = []
        for vertex in currentPoints:
            possible = [vertex + i for i in range(-r[vertex],r[vertex] + 1)]
            for index in possible:
                if index not in newCurr and (index not in visited and index not in currentPoints):
                    newCurr.append(index)
                    
        #visited += current
        for vertex in currentPoints:
            if vertex not in visited:
                visited.append(vertex)
        
        currentPoints = newCurr
        steps += 1
        if(steps == 20):
            return currentPoints
    
    return steps
            

n, s, t = input().strip().split(' ')
n, s, t = [int(n), int(s), int(t)]
r_0, g, seed, p = input().strip().split(' ')
r_0, g, seed, p = [int(r_0), int(g), int(seed), int(p)]
result = circularWalk(n, s, t, r_0, g, seed, p)
print(result)
