times = input()
v = 0
while v < times:
  
  trash = input()
  sequence = raw_input()
  print(sequence)
  nums = sequence.split()
  nums = map(int, nums)
  high = max(nums)
  low = min(nums)

  i = 0
  while i < len(nums):
    
    if nums[i] == low:
      temp = i
      temp += 1
      print temp,
    
    i += 1
  
  print
  
  i = 0
  while i < len(nums):
    
    if nums[i] == high:
      temp = i
      temp += 1
      print temp,
    
    i += 1
  
  print
  
  print
  v += 1
