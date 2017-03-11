def isPrime(number):
  #Check if even.
  if number % 2 == 0:
    return False
  i = 3
  while i < int(math.sqrt(number)):
    if number % i == 0:
      return False
    i += 2
  return True
