times = input()

i = 0
while i < times:
  
  length = input()
  
  ascents = 0
  descents = 0
  plateaus = 0
  maxA = 0
  maxD = 0
  maxP = 0
  
  sequence = []
  
  j = 0
  while j < length:
    
    currentNum = input()    
    sequence.append(currentNum)
    
    if j != 0:
      if currentNum < sequence[j-1]:
        #descent
    else:
      #first time you can do nothing except reset max length to 1 below
      maxA += 1
      maxD += 1
      maxP += 1
    
    j += 1
  
  i += 1
