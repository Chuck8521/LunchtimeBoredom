import math
from fractions import gcd

times = input()

i = 0
while i < times:
  
  line = raw_input()
  print('0.' + line + ' ='),
  
  parts = map(str, line.split())
  
  temp = parts[0]
  temp = '0.' + temp

  repDigit = int(parts[1])
  
  #All digits plus one set repeating - all digits
  
  bigNumber = float(temp)
  spliceSpot = int(len(temp) - repDigit)
  smallNumber = float(temp[0:spliceSpot])
  
  smallNumber *= float(math.pow(10,(len(parts[0]) - repDigit)))
  bigNumber *= float(math.pow(10,len(parts[0])))
  
  
  numer = bigNumber - smallNumber
  denom = float(math.pow(10,len(parts[0])))
  denom -= float(math.pow(10,(len(parts[0]) - repDigit)))
    
  GCD = gcd(numer,denom)
  numer /= GCD
  denom /= GCD
  
  numer = int(numer)
  denom = int(denom)
  
  print(str(numer) + '/' + str(denom))
  
  i += 1
