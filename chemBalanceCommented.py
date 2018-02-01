"""
Handles balancing of chemical equations.
"""
import functools
import string
from fractions import Fraction


#General idea of program: convert a chemical equation into a system of equations, then use 
#linear algebra to reduce that matrix into reduced row-echelon form and find solution.


#Declare three utility mathematical functions that will be used later (in the reduction of a matrix to row-echelon form).

def gcd(a, b):
    
    #Return greatest common divisor using Euclid's Algorithm.
    while b:   
        a, b = b, a % b
    return a

def lcm(a, b):
    
    #Return least common multiple.
    return a * b // gcd(a, b)

def lcmm(args):
    
    #Recursively apply the lcm function to find the least common multiple of all given ints in args.
    return functools.reduce(lcm, args)


#This function takes a matrix (a list of lists) and reduces it to reduced row-echelon form, where the solution is obvious.

def gauss_jordan(matrix):
    
    #currentM will be modified, while matrix will be static for the first half of the function (for ease).
    currentM = matrix
    
    #While currentM is not empty:
    while len(currentM) != 0 and len(currentM[0]) != 0:
    
        #Look at the first column. If it's all zeros, ignore and move on. 
        #If it contains a non-zero number, shift it up to first row (or keep in first row),
        #then carry the row switch through each row with a number in it
    
        #Construct next column.
        col = []
        for row in currentM:
            col.append(row[0])
    
        
        
        firstNonZeroRow = -1
        for index, entry in enumerate(col):
            if entry.numerator != 0:
                firstNonZeroRow = index
                break
            
        if firstNonZeroRow == -1:
            #Remove column and continue.
            newM = []
            for row in currentM:
                newM.append(row[1:])
            currentM = newM
            continue
    
        else:
            
            #If first nonzero row is not top, make it top. Then, reduce all remaining non-zero numbers in column.
            
            #Switch locally.
            if firstNonZeroRow != 0:
                temp = currentM[0]
                currentM[0] = currentM[firstNonZeroRow]
                currentM[firstNonZeroRow] = temp
              
                
            #Reduce all rows.
            newCurrent = []
            
            #Do first row special, to avoid later looping conflicts.
            firstRow = currentM[0]
            firstNum = firstRow[0]
            temp = []
            
            #Reduce numbers.
            for entry in firstRow:
                entry /= firstNum
                temp.append(entry)
                
            #Append and end. First row done.
            newCurrent.append(temp)
        
        
        
        
            #Reduce all other rows based off of mathematical relation to already reduced first row. 
            #For each number in each row, if the first number (in our column of interest) is not clear, then reduction required.
            for index, row in enumerate(currentM):
                if index != 0:
                    firstNum = row[0]
                    temp = []
                    
                    #Reduce row number by number at this level.
                    for number, entry in zip(newCurrent[0], row):
                        #Apply mathematical relationship between rows of a matrix to reduce efficiently.
                        temp.append(entry + (number * (-1 * firstNum)))
                    newCurrent.append(temp)
                
            #newCurrent is now a full replacement for current. Apply our reduction operations globally and locally, and then remove col and row locally,
            #to allow for looping through a smaller matrix next time, resulting in full reduction at the end of the run.
            
            
            #First, newCurrent needs to be nestled into the bottom right of matrix. That's where we have been changing entries.
            #i is row number
            for i in range(len(newCurrent)): 
                #j is entry
                for j in range(len(newCurrent[0])): 
                    #Replace wioth correct numbers.
                    matrix[len(matrix) - len(newCurrent) + i][len(matrix[0]) - len(newCurrent[0]) + j] = newCurrent[i][j]
        
        
        
            #Local switch and setup for next iteration.
            currentM = newCurrent[1:]
            temp = []
            for row in currentM:
                temp.append(row[1:])
            
            currentM = temp
        
            #Good to loop!
            continue       
        
        
    #Matrix is in row-echelon form, but not reduced!
    #So now, reduce it.
    i = 0
    while i < len(matrix):
        
        position = -1
        #If there's a leading 1 in this row, get its position.
        for index, num in enumerate(matrix[i]):
            
            if num.numerator != 0:
                position = index
                break
            
        #If position does equal -1, it's a zero row and doesn't need attention.
        if position != -1: 
            
            for index, row in enumerate(matrix):
                
                #Can't reduce a row by itself or you get an invalid 0 row.
                if  index != i: 
                    
                    #A reduction is needed if this is true:
                    if row[position] != 0:
                        
                       
                        #Create a new temporary row and populate with Fraction zeroes.
                        newRow = [Fraction(0,1)] * len(row)
                        
                        #Synchronize new row.
                        for ind, num in enumerate(matrix[index]):
                            newRow[ind] = num
                        
                        #Loop and modify each row, similar to the procedure above for achieving row-echelon form.
                        j = position                        
                        while j < len(row):
                            
                            #Reduction based on mathematical formula proven by author of code.
                            newRow[j] = row[j] - (matrix[i][j] * Fraction(row[position], matrix[i][position]))
                            
                            j += 1
                            
                        #Apply change globally.
                        matrix[index] = newRow
        
        #Loop to next row until done!
        i += 1
    
       
    

#Input text processing takes place here.
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
                    if currentElement[-1].isdigit() and currentElement[-2].isdigit():

                        #Two-digit number!
                        numberOnes = int(currentElement[-1])
                        numberTens = int(currentElement[-2])
                        number = (numberTens * 10) + numberOnes
                        currentElement = currentElement[:len(currentElement) - 2]
                    elif currentElement[-1].isdigit():
                        #One-digit number only.
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
        if currentElement[-1].isdigit() and currentElement[-2].isdigit():

            numberOnes = int(currentElement[-1])
            numberTens = int(currentElement[-2])
            number = (numberTens * 10) + numberOnes
            if currentElement[0:len(currentElement) - 2] in result:
                result[currentElement[0:len(currentElement) - 2]] += number
            else:
                result[currentElement[0:len(currentElement) - 2]] = number
        elif currentElement[-1].isdigit():
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



#Utility method, to generate a standard ordering of chemicals based on a given list of dictionaries (the input).
#Output: A list of strings, in a random order, that can arbitrarily be declared a standard order.

def generateList(side):

    result = []
    
    #Simple loop through the input, inspection and assignment to result only.
    for dic in side:
        for key in dic:
            if key not in result:
                result.append(key)      
    
    
    return result




#Where the magic happens, and all the code is tied together.
def balanceEq():
    
    #GET INPUT HERE --------------------------------------------------------------------------------------------------
    equation = input()
    
    
    sides = equation.split("=")
    partsL = sides[0].split("+")
    partsR = sides[1].split("+")
    
    #We have compounds. Make a system of equations.
    
    #Make lists of lists. Each list has [element, num] for each compound
    
    elementsL = Numerize(partsL)
    elementsR = Numerize(partsR)
    
    
    
    #Alright, assume Numerize worked. We have dicts for each compound in elementsL and elementsR.
    
    template = generateList(elementsL)
    
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
        
        

    
    #Construct transpose of true matrix.
    trueArT = arL
    for col in arR:
        newCol = []
        for num in col:
            newCol.append(num * -1)
        trueArT.append(newCol)
        
        
    #Take transpose of trueArT to get trueAr
    trueAr = []
    
    i = 0
    while i < len(trueArT[0]):
        
        newRow = []
        for row in trueArT:
            newRow.append(row[i])
            
        trueAr.append(newRow)
        
        i += 1
    
    
    
    
    
    
    
    #trueAr is in the right form.
    #Just reduce to reduced row-echelon form, and solving is simple!
    
    

    gauss_jordan(trueAr)
    
    #In reduced R-E form! Solve and output!
    lastDenoms = []
    lastFracts = []
    for row in trueAr:
        lastDenoms.append(row[-1].denominator)
        lastFracts.append(-1 * row[-1])
    
    #Find lowest scalar mult that makes lastNum contain only ints
    scalarMult = lcmm(lastDenoms)
    
    coefs = []
    for fract in lastFracts:
        if fract.numerator != 0:
            coefs.append(int(fract * scalarMult))
        
    coefs.append(scalarMult)
    
    
    
    
    
    
    
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









#__-------------------------------------------------------------------TESTING ONLY
balanceEq()












