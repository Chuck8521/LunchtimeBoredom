#!/bin/python3

import sys

def boolProd(m1, m2):
    

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
                
    
    #boolMatrix is now right. Take products till answer and count steps
    
    
    
    
    return boolMatrix
            

n, s, t = input().strip().split(' ')
n, s, t = [int(n), int(s), int(t)]
r_0, g, seed, p = input().strip().split(' ')
r_0, g, seed, p = [int(r_0), int(g), int(seed), int(p)]
result = circularWalk(n, s, t, r_0, g, seed, p)
print(result)
