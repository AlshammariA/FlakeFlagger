@Test public void testConcurrent() throws Exception {
  final Exception[] ex=new Exception[1];
  Thread[] threads=new Thread[THREAD_COUNT];
  for (int i=0; i < THREAD_COUNT; i++) {
    final Session s=createAdminSession();
    final String node="node" + i;
    Thread t=new Thread(){
      @Override public void run(){
        try {
          doTest(s,node);
        }
 catch (        Exception e) {
          ex[0]=e;
        }
      }
    }
;
    threads[i]=t;
  }
  for (  Thread t : threads) {
    t.start();
  }
  Thread.sleep(100);
  for (  Thread t : threads) {
    t.join();
  }
  if (ex[0] != null) {
    throw ex[0];
  }
}
