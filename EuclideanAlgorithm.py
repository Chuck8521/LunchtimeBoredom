trueA = input('Larger number: ')
trueB = input('Smaller number: ')

a = trueA
b = trueB

while a % b != 0:
   oldA = a
   equation = str(a) + ' = ' + str(a/b) + ' * ' + str(b) + ' + ' + str(a%b)
   print(equation)
   a = b
   b = oldA % b
   
gcf = b

print('The GCF is: ' + str(gcf)) 
   
