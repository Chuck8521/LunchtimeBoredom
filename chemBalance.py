# -*- coding: utf-8 -*-
"""
Created on Tue Jan  9 17:18:20 2018

@author: Supreme
"""
import functools
import string
from fractions import Fraction

numOfElements = 0


def gcd(a, b):
    """Return greatest common divisor using Euclid's Algorithm."""
    while b:      
        a, b = b, a % b
    return a

def lcm(a, b):
    """Return lowest common multiple."""
    return a * b // gcd(a, b)

def lcmm(args):
    """Return lcm of args."""   
    return functools.reduce(lcm, args)


def gauss_jordan(matrix):
    
    #Got all data. Get in R-E form.
    currentM = matrix
    while len(currentM) != 0 and len(currentM[0]) != 0:
        #Modify currentM, save stuff in matrix.
    
        #Look at col. If all zeros, ignore. If has a number, shift up to first row (or keep in first row, whatev)
        #then carry it through each row with a number in it
    
        col = []
        for row in currentM:
            col.append(row[0])
    
        nonZero = False
        firstNonZeroRow = -1
        for index, entry in enumerate(col):
            #print(str(index) + " " + str(entry)) #for debug
            if entry.numerator != 0:
                nonZero = True
                firstNonZeroRow = index
                break
            
        if not nonZero:
            #Remove column and continue.
            newM = []
            for row in currentM:
                newM.append(row[1:])
            currentM = newM
            continue
    
        else:
            #If first nonzero row is not top, make it top. Then, reduce all remaining if not 0 in column.
            if firstNonZeroRow != 0:
                #Switch locally.
                temp = currentM[0]
                currentM[0] = currentM[firstNonZeroRow]
                currentM[firstNonZeroRow] = temp
            
                #Switch globally. MAYBE JUST SWITCH ALL AT END
                #temp = matrix[len(matrix) - len(col)] #top row in true matrix
                #matrix[len(matrix) - len(col)] = matrix[len(matrix) - len(col) + firstNonZeroRow]
                #matrix[len(matrix) - len(col) + firstNonZeroRow] = temp
    
            
            
            #Reduce all rows.
            newCurrent = []
            #Do first row special?
            firstRow = currentM[0]
            firstNum = firstRow[0]
            temp = []
            for entry in firstRow:
                entry /= firstNum
                temp.append(entry)
            newCurrent.append(temp)
        
        
        
            for num, row in enumerate(currentM):
                if num != 0:
                    firstNum = row[0]
                    temp = []
                    for number, entry in zip(newCurrent[0], row):
                        temp.append(entry + (number * (-1 * firstNum)))
                    newCurrent.append(temp)
                
            #newCurrent is now a full replacement for current. Switch globally and locally, and then remove col and row locally
            #Global.
            #newCurrent needs to be nestled into the bottom right of matrix.
            for i in range(len(newCurrent)): #i is rows
                for j in range(len(newCurrent[0])): #j is entry
                    matrix[len(matrix) - len(newCurrent) + i][len(matrix[0]) - len(newCurrent[0]) + j] = newCurrent[i][j]
        
        
        
            #Local.
            currentM = newCurrent[1:]
            temp = []
            for row in currentM:
                temp.append(row[1:])
            
            currentM = temp
        
            #Good to loop... I think.
            #print(matrix) #for debug
            continue
    
    
        
        
        i += 1
        
    return True
    
    
def reduceToRRE(matrix):
    
    #Matrix is in RE form. Not reduced!
    #So now, reduce it.
    i = 0
    while i < len(matrix):
        
        position = -1
        #If there's a leading 1 in this row, get its position
        for index, num in enumerate(matrix[i]):
            
            if num.numerator != 0:
                position = index
                break
            
        
        if position != -1: #If it does equal -1, it's a zero row and we don't care
            
            for index, row in enumerate(matrix):
                
                if  index != i: #Can't reduce a row by itself or you get 0 row
                    if row[position] != 0:
                        
                        j = position
                        newRow = [Fraction(0,1)] * len(row)
                        #populate new row
                        for ind, num in enumerate(matrix[index]):
                            newRow[ind] = num
                        
                        
                        
                        while j < len(row):
                            #print(str(row[position]))
                            #if row[j].numerator != 0:
                            #matrix[index][j] -= matrix[i][j] * Fraction(row[position], matrix[i][position]) #TODO divide by 0
                            newRow[j] = row[j] - (matrix[i][j] * Fraction(row[position], matrix[i][position]))
                            j += 1
                            
                        
                        matrix[index] = newRow
                #newM.append(newR)
        i += 1
    
       
    
    return True 


#Do my text processing plz and thx
def Numerize(compound):
    finalResult = []
    for entry in compound:
        result = {} #dict
        currentElement = ""
        for index, char in enumerate(entry):
            if char in string.ascii_uppercase:
                if currentElement == "":
                    currentElement = char
                else:
                 
                    number = 1
                    if currentElement[-1].isdigit():
                        number = int(currentElement[-1])
                        currentElement = currentElement[:len(currentElement) - 1]
                    
                    if currentElement in result:
                        result[currentElement] += number
                    else:
                        result[currentElement] = number
                    currentElement = char
            else:
                currentElement += char 
        
        number = 1
        if currentElement[-1].isdigit():
            number = int(currentElement[-1]) #TODO TWO DIGIT
            if currentElement[0:len(currentElement) - 1] in result:
                result[currentElement[0:len(currentElement) - 1]] += number
            else:
                result[currentElement[0:len(currentElement) - 1]] = number
                
        else: #just a letter here, num 1 understood
            if currentElement in result:
                result[currentElement] += number
            else:
                result[currentElement] = number
       
        finalResult.append(result)
            
    
    return finalResult


def generateList(side):
    
    #side is a list of dicts
    result = []
    
    for dic in side:
        for key in dic:
            if key not in result:
                result.append(key)      
    
    
    return result



#GET INPUT HERE --------------------------------------------------------------------------------------------------
equation = input()








sides = equation.split("=")
partsL = sides[0].split("+")
partsR = sides[1].split("+")

#We have compounds. Make a system of equations.

#Make lists of lists. Each list has [element, num] for each compound

elementsL = Numerize(partsL)
elementsR = Numerize(partsR)

#print(elementsL)
#print(elementsR)


#Alright, assume Numerize worked. We have dicts for each compound in elementsL and elementsR.

modL = elementsL
modR = elementsR

template = generateList(modL)
#print(template)

arL = []
arR = []

for compound in elementsL:
    column = []
    for element in template:
        if element in compound:
            column.append(Fraction(compound[element],1))
        else:
            column.append(Fraction(0,1))
    arL.append(column)
    

    
for compound in elementsR:
    column = []
    for element in template:
        if element in compound:
            column.append(Fraction(compound[element],1))
        else:
            column.append(Fraction(0,1))
    arR.append(column)
    
    
#print(arL)
#print(arR)

#Construct transpose of true matrix.
trueArT = arL
for col in arR:
    newCol = []
    for num in col:
        newCol.append(num * -1)
    trueArT.append(newCol)
    
#Take transpose of trueArT
trueAr = []

i = 0
while i < len(trueArT[0]):
    
    newRow = []
    for row in trueArT:
        newRow.append(row[i])
        
    trueAr.append(newRow)
    
    i += 1


#print(trueAr)





#trueAr is in the right form
#RE time


m = trueAr
valid = gauss_jordan(m)
#print(m)
#print(valid)





valid2 = reduceToRRE(m)
#print(m)


#In reduced R-E form! TODO
lastDenoms = []
lastFracts = []
for row in m:
    lastDenoms.append(row[-1].denominator)
    lastFracts.append(-1 * row[-1])
    
#Find lowest scalar mult that makes lastNum contain only ints
scalarMult = lcmm(lastDenoms)
#print(scalarMult)

coefs = []
for fract in lastFracts:
    if fract.numerator != 0:
        coefs.append(int(fract * scalarMult))
    
coefs.append(scalarMult)
#print(coefs)







#Output result!
out = ""
i = 0
while i < len(coefs):
    
    if i < len(partsL):
        if i != 0:
            out += "+"
        out += str(coefs[i])
        out += partsL[i]
    else:
        if i == len(partsL):
            out += "="
        else:
            out += "+"
        out += str(coefs[i])
        out += partsR[i - len(partsL)]
        
    
    i += 1




#PRINT RESULT HERE ----------------------------------------------------------------------------------
print(out)

































