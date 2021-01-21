@Test public void testRandomOperations(){
  boolean log=false;
  int size=10;
  Random r=new Random(1);
  for (int j=0; j < 100; j++) {
    CacheLIRS<Integer,Integer> test=createCache(size / 2);
    HashMap<Integer,Integer> good=new HashMap<Integer,Integer>();
    for (int i=0; i < 10000; i++) {
      int key=r.nextInt(size);
      int value=r.nextInt();
switch (r.nextInt(3)) {
case 0:
        if (log) {
          System.out.println(i + " put " + key+ " "+ value);
        }
      good.put(key,value);
    test.put(key,value);
  break;
case 1:
if (log) {
  System.out.println(i + " get " + key);
}
Integer a=good.get(key);
Integer b=test.getIfPresent(key);
if (a == null) {
assertNull(b);
}
 else if (b != null) {
assertEquals(a,b);
}
break;
case 2:
if (log) {
System.out.println(i + " remove " + key);
}
good.remove(key);
test.remove(key);
break;
}
if (log) {
System.out.println(" -> " + toString(test));
}
}
verify(test,null);
}
}
