@Test(expected=IllegalStateException.class) public void notStarted() throws ExecutionException, InterruptedException {
  ManagementOperation op=ManagementOperation.done("test",42);
  assertTrue(op.isDone());
  assertEquals(42,(long)op.get());
  sameThreadExecutor().execute(op);
}
