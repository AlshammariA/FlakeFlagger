@Test public void failed() throws InterruptedException, TimeoutException {
  final Exception failure=new Exception("fail");
  ManagementOperation op=new ManagementOperation("test",new Callable<Long>(){
    @Override public Long call() throws Exception {
      throw failure;
    }
  }
);
  executor.execute(op);
  try {
    assertEquals(42,(long)op.get(5,SECONDS));
    fail("Expected " + failure);
  }
 catch (  ExecutionException e) {
    assertEquals(failure,e.getCause());
  }
  assertTrue(op.isDone());
  Status status=op.getStatus();
  assertEquals(op.getId(),status.getId());
  assertEquals(FAILED,status.getCode());
  assertEquals("test failed: " + failure.getMessage(),status.getMessage());
}
