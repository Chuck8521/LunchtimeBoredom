#!/bin/python3

import sys


def circularWalk(n, s, t, r_0, g, seed, p):
    # Complete this function
    
    if s == t:
        return 0
    
    visited = []
    currentPoints = [s]
    steps = 0
    #When t is in visited, stop
    while t not in currentPoints:
        
        if len(currentPoints) == 0:
            return -1
        
        newCurr = []
        for vertex in currentPoints:
            #TODO
            if index not in newCurr and index not in visited and index not in currentPoints:
                newCurr.append(index)
                    
        #visited += current
        for vertex in currentPoints:
            if vertex not in visited:
                visited.append(vertex)
        
        currentPoints = newCurr
        steps += 1
        
        #Take all of visited's points out of current
        for v in currentPoints:
            if v in visited:
                currentPoints.remove(v)
                
    
    return steps
            

n, s, t = input().strip().split(' ')
n, s, t = [int(n), int(s), int(t)]
r_0, g, seed, p = input().strip().split(' ')
r_0, g, seed, p = [int(r_0), int(g), int(seed), int(p)]
result = circularWalk(n, s, t, r_0, g, seed, p)
print(result)
