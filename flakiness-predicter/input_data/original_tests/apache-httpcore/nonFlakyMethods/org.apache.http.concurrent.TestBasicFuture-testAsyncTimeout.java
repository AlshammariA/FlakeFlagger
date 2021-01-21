@Test(expected=TimeoutException.class) public void testAsyncTimeout() throws Exception {
  final BasicFuture<Object> future=new BasicFuture<Object>(null);
  final Object result=new Object();
  Thread t=new Thread(){
    @Override public void run(){
      try {
        Thread.sleep(200);
        future.completed(result);
      }
 catch (      InterruptedException ex) {
      }
    }
  }
;
  t.setDaemon(true);
  t.start();
  future.get(1,TimeUnit.MILLISECONDS);
}
