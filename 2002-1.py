times = input()

i = 0

while i < times:
    
    line = raw_input()
    elements = map(int, line.split())
    
    element1 = elements[0]
    element2 = elements[1]
    
    length = elements[2]
    length -= 2
    
    past1 = element2
    past2 = element1
    
    print(past2),
    print(past1),
    
    nextElement = 0
    
    j = 0
    
    while j < length:
    
        nextElement = past1 + past2
        
        past2 = past1
        past1 = nextElement
        
        print(nextElement),
        
        j += 1
    
    print('')
    
    i += 1
