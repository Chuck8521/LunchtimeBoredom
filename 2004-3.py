times = input()
p = 0
while p < times:
  
  line = raw_input()
  floats = map(float, line.split())
  
  if floats[4] - floats[2] == 0:
    if floats[0] == floats[4]:
      print "({},{}) lies on line segment (({},{}), ({},{}))".format(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5])
    else:
      print "({},{}) does not lie on line segment (({},{}), ({},{}))".format(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5])
    continue
  m = (floats[5] - floats[3]) / (floats[4] - floats[2])
  y = (m*(floats[0] - floats[4])) + floats[5]
  
  valid = False
  x = floats[0]
  if x < floats [2] and x > floats[4]:
    if flaots[1] < floats [3] and floats[1] > floats[5]:
      valid = True
  
  if abs(y - floats[1])/max(y,floats[1]) <= .001 and valid:
    #on line
    print "({},{}) lies on line segment (({},{}), ({},{}))".format(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5])
  else:
    #not
    print "({},{}) does not lie on line segment (({},{}), ({},{}))".format(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5])
  p += 1
