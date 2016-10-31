#2006 - 5
#This is only a test.

times = raw_input()
while times > 0:
  sizeOfTable = raw_input()
  operationTable = []
  i = 0
  while i < sizeOfTable:
    operationTable.append(raw_input())
    i = i + 1;
  numProblems = raw_input()
  i = 0
  while i < numProblems:
    problem = raw_input()
    for ltr in problem:
      if ltr == ')':
        #get all letters before it until you reach (
        subproblem = ""
        currentIndex = problem.index(ltr)
        
    i = i + 1
  
  times = times - 1;
