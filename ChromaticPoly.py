def GetPolynomial(connections, assignments, currentVert):
  if currentVert == 0:
    #assign x to 0
    assignments[0] = 'x'
    #move to adj and assign
    nextVert = connections[0][0]
  
  else:
    #See how many this vert has adj AND ASSIGNED
    adjAssigned = []
    numAssigned = 0
    for vert in connections[currentVert]:
      if assignments[vert] != '':
        #Assigned. Increment counter
        numAssigned += 1
        adjAssigned.append(vert)
      
    if numAssigned == 1:
      #must be x-1
      assignments[currentVert] = 'x-1'
      
        
    elif numAssigned == 2:
      #Check if they are guaranteed one way or the other OR ADJ
      guaranteedDiff = False
      if adjAssigned[1] in connections[adjAssigned[0]]:
        guaranteedDiff = True
        
      #TODO Conditions with uncertainty
      if guaranteedDiff:
        assignments[currentVert] = 'x-2'
        
        
      else:
        #branch TODO
        pass
        
      
    #Next vert equals some connected vert not Assigned - no matter what the degree is of current vert
    someNum = 0
    nextVert = connections[currentVert][someNum]
    while assignments[nextVert] != '':
      someNum += 1
      if someNum >= len(connections[currentVert]):
        #Completed graph. Return.
        return assignments
      nextVert = connections[currentVert][someNum]
    
    return GetPolynomial(connections, assignments, nextVert)
    






numVertices = int(input())

connections = [[] for q in range(numVertices)]


line = list(map(int,input().split()))
while line[0] != -1:
  connections[line[0]].append(line[1])
  connections[line[1]].append(line[0])
  line = list(map(int,input().split()))
  
for index, array in enumerate(connections):
  print(connections[index])



assignments = ['' for q in range(numVertices)]
currentVert = 0

#assign x to 0
assignments[0] = 'x'
#move to adj and assign
nextVert = connections[0][0]


out = sorted(GetPolynomial(connections,assignments,nextVert))
print(out)
