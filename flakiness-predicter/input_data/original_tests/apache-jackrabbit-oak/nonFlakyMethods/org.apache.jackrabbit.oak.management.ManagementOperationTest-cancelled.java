@Test public void cancelled(){
  ManagementOperation op=new ManagementOperation("test",new Callable<Long>(){
    @Override public Long call() throws Exception {
      return 0L;
    }
  }
);
  op.cancel(false);
  executor.execute(op);
  assertTrue(op.isDone());
  Status status=op.getStatus();
  assertEquals(op.getId(),status.getId());
  assertEquals(FAILED,status.getCode());
  assertEquals("test cancelled",status.getMessage());
}
