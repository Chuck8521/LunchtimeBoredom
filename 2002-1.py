times = input()

i = 0

while i < times:
    
    element1 = input()
    element2 = input()
    
    length = input()
    length -= 2
    
    past1 = element2
    past2 = element1
    
    print(past2)
    print(past1)
    
    nextElement = 0
    
    while j < length:
    
        nextElement = past1 + past2
        
        past2 = past1
        past1 = nextElement
        
        print(nextElement)
        
        j++
    
    i++
