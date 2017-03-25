import operator

numbers = [0] * 1000000

length = {}

i = 3
while i < 1000000:
  if numbers[i - 1] is 0:
    temp = i
    len = 1
    while temp != 1:
      if temp % 2 == 0:
        temp /= 2
      else:
        temp = (temp * 3) + 1
        
      if temp - 1 < 1000000:
        numbers[temp - 1] = 1
      len += 1
      
    length[i] = length
  i += 2
  

sortedLength = sorted(length.items(), key=operator.itemgetter(1))
for x in sortedLength:
  print x[0], x[1]

