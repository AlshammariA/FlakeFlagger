@Test public void testRandomOperations() throws Exception {
  Random r=new Random(1);
  final CacheLIRS<Integer,Integer> cache=new CacheLIRS.Builder().maximumWeight(100).averageWeight(10).build();
  final Exception[] ex=new Exception[1];
  int size=3;
  Thread[] threads=new Thread[size];
  final AtomicBoolean stop=new AtomicBoolean();
  for (int i=0; i < size; i++) {
    Thread t=new Thread(){
      @Override public void run(){
        while (!stop.get()) {
          try {
            cache.cleanUp();
            cache.containsKey(1);
            cache.containsValue(2);
            cache.entrySet();
            cache.getMaxMemory();
            cache.getIfPresent(3);
            cache.getAverageMemory();
            cache.getMemory(4);
            cache.getUsedMemory();
            cache.invalidate(5);
            cache.invalidateAll();
            cache.isEmpty();
            cache.keySet();
            cache.peek(6);
            cache.put(7,8);
            cache.refresh(9);
            cache.remove(10);
            cache.setAverageMemory(11);
            cache.setMaxMemory(12);
            cache.size();
            cache.stats();
            ConcurrentMap<Integer,Integer> map=cache.asMap();
            map.size();
            map.isEmpty();
            map.containsKey(1);
            map.containsValue(1);
            map.get(11);
            map.put(12,10);
            map.remove(13);
            map.clear();
            map.keySet();
            map.values();
            map.entrySet();
            map.putIfAbsent(14,10);
            map.remove(15);
            map.remove(16,10);
            map.replace(17,10,100);
            map.replace(18,10);
            cache.get(19);
            cache.getUnchecked(1);
          }
 catch (          Exception e) {
            ex[0]=e;
          }
        }
      }
    }
;
    t.start();
    threads[i]=t;
  }
  try {
    long start=System.currentTimeMillis();
    while (System.currentTimeMillis() < start + 1000) {
      for (int i=0; i < 100000 && ex[0] == null; i++) {
        cache.put(r.nextInt(10),r.nextInt(10000));
      }
    }
  }
  finally {
    stop.set(true);
    for (    Thread t : threads) {
      t.join();
    }
  }
  if (ex[0] != null) {
    throw ex[0];
  }
}
