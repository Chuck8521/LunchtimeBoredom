line = input().split()

size = [0 for num in range(len(line))]

for index, word in enumerate(line):
  for word2 in line:
    if word != word2:
      ac = True
      for letter in word:
        if letter not in word2:
          ac = False
          
      for let in word2:
        if let not in word:
          ac = False
          
      if ac:
        size[index] += 1
        
        
high = max(size)
out = []
for dex, entry in enumerate(size):
  if entry == high:
    out.append(line[dex])
    
print(out)
