times = input()

i = 0

while i < times:
    
    line = input()
    map(int, line.split())
    
    element1 = map(0)
    element2 = map(1)
    
    length = map(2)
    length -= 2
    
    past1 = element2
    past2 = element1
    
    print(past2,)
    print(past1,)
    
    nextElement = 0
    
    j = 0
    
    while j < length:
    
        nextElement = past1 + past2
        
        past2 = past1
        past1 = nextElement
        
        print(nextElement,)
        
        j += 1
    
    i += 1
