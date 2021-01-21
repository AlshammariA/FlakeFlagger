@Test public void testRandomSmallCache(){
  Random r=new Random(1);
  for (int i=0; i < 10000; i++) {
    int j=0;
    StringBuilder buff=new StringBuilder();
    CacheLIRS<Integer,Integer> test=createCache(1 + r.nextInt(10));
    for (; j < 30; j++) {
      int key=r.nextInt(5);
switch (r.nextInt(3)) {
case 0:
        int memory=r.nextInt(5) + 1;
      buff.append("add ").append(key).append(' ').append(memory).append('\n');
    test.put(key,j,memory);
  break;
case 1:
buff.append("remove ").append(key).append('\n');
test.invalidate(key);
break;
case 2:
buff.append("get ").append(key).append('\n');
test.getIfPresent(key);
}
}
}
}
