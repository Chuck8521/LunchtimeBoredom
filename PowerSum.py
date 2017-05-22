import math

def isPowerSum(target,upperBound,lowerBound,power):
    
    target -= lowerBound ** power
    
    if target == 0:
        return 1
    elif target > 0:
        ways = 0
        i = lowerBound + 1
        while i <= upperBound:
            ways += isPowerSum(target,upperBound,i,power)
            i += 1
        return ways
    else:
        return 0
    
target = int(input())
power = int(input())
upperBound = math.sqrt(target)

i = 1
ways = 0 

while i <= upperBound:
    ways += isPowerSum(target,upperBound,i,power)    
    i += 1
    
print(ways)
