@Test public void succeeded() throws InterruptedException, ExecutionException, TimeoutException {
  ManagementOperation op=new ManagementOperation("test",new Callable<Long>(){
    @Override public Long call() throws Exception {
      return 42L;
    }
  }
);
  executor.execute(op);
  assertEquals(42,(long)op.get(5,SECONDS));
  assertTrue(op.isDone());
  Status status=op.getStatus();
  assertEquals(op.getId(),status.getId());
  assertEquals(SUCCEEDED,status.getCode());
  assertTrue(status.getMessage().contains("test completed in"));
}
