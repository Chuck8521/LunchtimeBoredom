import operator
import collections

events = input()

allN = []
gold = {}
silver = {}
bronze = {}

i = 0
while i < events:
   
   line = raw_input()
   nation = map(str, line.split())
   
   g = nation[0]
   s = nation[1]
   b = nation[2]
   
   if g in gold:
      gold[g] += 1
   else:
      gold[g] = 1
      if g not in allN:
         allN.append(g)
      
   if s in silver:
      silver[s] += 1
   else:
      silver[s] = 1
      if s not in allN:
         allN.append(s)
      
   if b in bronze:
      bronze[b] += 1
   else:
      bronze[b] = 1
      if b not in allN:
         allN.append(b)
   
   i += 1
   
   
print('     G  S  B  T')


totals = {}


for key in allN:
   
    total = 0

    if key in gold:
      total += gold[key]
      
    if key in silver:
      total += silver[key]
      
    if key in bronze:
      total += bronze[key]
    
    totals[key] = total



sorted_totals = sorted(totals.items(), key=operator.itemgetter(1)) #INCREDIBLY USEFUL
sorted(allN)
sorted_gold = sorted(gold.items(), key=operator.itemgetter(1))
sorted_silver = sorted(silver.items(), key=operator.itemgetter(1))






"""for key in allN:
   
    total = 0

    print key,
    if key in gold:
      print gold[key],
      total += gold[key]
    else:
      print '0',
      
    if key in silver:
      print silver[key],
      total += silver[key]
    else:
      print '0',
      
    if key in bronze:
      print bronze[key],
      total += bronze[key]
    else:
      print '0',
    
    print total"""
