def ParentOf(n, arr):
    if arr[n] == n:
        return n
    else:
        return ParentOf(arr[n],arr)

n, p = list(map(int, input().split()))
arr = []
for t in range(0,n):
    arr.append(t)

for q in range(p):
    #Quick Union the line
    first, sec = list(map(int,input().split()))
    arr[first] = ParentOf(sec)
    
#Get number of people in each group
groups = []
for q in range(0,n):
    groups[q] = arr.count(q)
    
    
#groups is accurate if 0's removed
trueG = []
for t in groups:
    if t != 0:
        trueG.append(t)
        
ways = 0
for index, a in enumerate(trueG):
    i = index + 1
    while i < len(trueG):
        ways += a * trueG[i]
        i += 1
        
print(str(ways))
        
    
    
    
    
