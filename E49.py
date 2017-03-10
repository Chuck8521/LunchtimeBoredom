import math
from collections import Counter

#Find all primes between 1000 and 9999
primes = []
i = 1001
while i < 9999:
  
  prime = True
  
  for x in range(3, int(math.sqrt(i) + 1.0)):
    if i % x == 0:
      prime = False
  
  if prime:
    primes.append(i)
  
  i += 2

#Find three with equal distance from each other THAT ARE PERMUTATIONS
for num in primes:
  for x in primes:
    if x != num:
      distance = abs(num - x)
      temp = num + (distance / 2)
      if temp in primes:
        #Check for permutational condition
        letters1 = list(str(num))
        letters2 = list(str(num + (distance / 2)))
        letters3 = list(str(num + distance))
        
        valid = False
        
        if Counter(letters3) == Counter(letters2):
          if Counter(letters2) == Counter(letters1):
            if Counter(letters1) == Counter(letters3):
              valid = True
            
        if valid:
          print num,
          num += (distance / 2)
          print num,
          print x


