for p in range(0,int(input())):
  size = int(input())
  
  out = '+'
  out += '-' * ((size * 2) - 1)
  out += '+'
  
  print(out)
  
  spaces = size - 1
  slashes = 0
  for q in range(0,size):
    line = '|'
    line += ' ' * spaces
    line += '/' * slashes
    line += '*'
    line += '\\' * slashes
    line += ' ' * spaces
    line += '|'
    print(line)
    spaces -= 1
    slashes += 1
    
    
  spaces = 0
  slashes = size - 1
  for q in range(0,size):
    line = '|'
    line += ' ' * spaces
    line += '\\' * slashes
    line += '*'
    line += '/' * slashes
    line += ' ' * spaces
    line += '|'
    print(line)
    spaces += 1
    slashes -= 1
  
  print(out)
  
  spaces = 0
  slashes = size - 1
  for q in range(0,size):
    line = '|'
    line += ' ' * spaces
    line += '\\' * slashes
    line += '*'
    line += '/' * slashes
    line += ' ' * spaces
    line += '|'
    print(line)
    spaces += 1
    slashes -= 1
  
  
  
  
  
  
  
  spaces = size - 1
  slashes = 0
  for q in range(0,size):
    line = '|'
    line += ' ' * spaces
    line += '/' * slashes
    line += '*'
    line += '\\' * slashes
    line += ' ' * spaces
    line += '|'
    print(line)
    spaces -= 1
    slashes += 1
    
    
  print(out)
