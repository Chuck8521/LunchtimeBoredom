#!/bin/python3

import sys


def circularWalk(n, s, t, r_0, g, seed, p):
    # Complete this function
    dist = []
    boolMatrix = [[] for w in range(n)]
    for w in range(n):
        for e in range(n):
            boolMatrix[w].append(0)
    for q in range(n):
        if q == 0:
            dist.append(r_0)
            i = 1
            while i <= r_0:
                boolMatrix[q][q+i] = 1
                boolMatrix[q][q-i] = 1
                i += 1
        else:
            dist.append((dist[q - 1] * g + seed) % p)
            i = 1
            while i <= (dist[q - 1] * g + seed) % p:
                if q+i < n:
                    boolMatrix[q][q+i] = 1
                else:
                    boolMatrix[q][(q+i) % n] = 1
                boolMatrix[q][q-i] = 1
                i += 1
                
    #boolMatrix is now right CONFIRMED. See what's going on
    visited = []
    currentPoints = [s]
    steps = 0
    #When t is in visited
    while t not in visited:
        newCurr = []
        for vertex in currentPoints:
            line = boolMatrix[vertex]
            for index, num in enumerate(line):
                if num == 1 and index not in newCurr and index not in visited and index not in currentPoints:
                    newCurr.append(index)
                    
        #visited += newCurr
        for vertex in currentPoints:
            if vertex not in visited:
                visited.append(vertex)
        
        currentPoints = newCurr
        steps += 1
        
        #Take all of visited's points out of current
        for v in currentPoints:
            if v in visited:
                currentPoints.remove(v)
    
    return steps - 1 #Because of how stuff is added to visited
            

n, s, t = input().strip().split(' ')
n, s, t = [int(n), int(s), int(t)]
r_0, g, seed, p = input().strip().split(' ')
r_0, g, seed, p = [int(r_0), int(g), int(seed), int(p)]
result = circularWalk(n, s, t, r_0, g, seed, p)
print(result)
