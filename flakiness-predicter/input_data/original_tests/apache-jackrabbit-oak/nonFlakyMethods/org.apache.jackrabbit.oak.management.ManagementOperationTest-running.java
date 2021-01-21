@Test public void running() throws InterruptedException {
  final LinkedBlockingDeque<Thread> thread=new LinkedBlockingDeque<Thread>(1);
  ManagementOperation op=new ManagementOperation("test",new Callable<Long>(){
    @Override public Long call() throws Exception {
      thread.add(currentThread());
      sleep(100000);
      return 0L;
    }
  }
);
  executor.execute(op);
  Status status=op.getStatus();
  assertEquals(op.getId(),status.getId());
  assertEquals(RUNNING,status.getCode());
  thread.poll(5,SECONDS).interrupt();
  try {
    op.get();
    fail("Expected InterruptedException");
  }
 catch (  ExecutionException e) {
    assertTrue(e.getCause() instanceof InterruptedException);
  }
  assertTrue(op.isDone());
  status=op.getStatus();
  assertEquals(op.getId(),status.getId());
  assertEquals(FAILED,status.getCode());
  assertTrue(status.getMessage().contains("test failed: "));
}
