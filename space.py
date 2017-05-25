def ParentOf(n, arr):
    if arr[n] == n:
        return n
    else:
        return ParentOf(arr[n],arr)

n, p = list(map(int, input().split()))
arr = [t for t in range(0,n)]

for q in range(p):
    #Quick Union the line
    first, sec = list(map(int,input().split()))
    lookFor = arr[first]
    arr[first] = ParentOf(sec,arr)
    changeTo = arr[first]
    for w in range(n):
        if arr[w] == lookFor:
            arr[w] = changeTo
            
#print(arr)
    
nu = set(arr)
#Get number of people in each group
groups = [0] * n
for q in nu:
    temp = arr.count(q)
    if temp > 0:
        groups[q] = temp
    
        
ways = 0
for index, a in enumerate(groups):
    i = index + 1
    while i < len(groups):
        ways += a * groups[i]
        i += 1
        
print(str(ways))
        
    
    
    
    
