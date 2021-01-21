@Test public void shouldInheritContextInCreatedThread() throws Exception {
  Context.set(context);
  WroTestUtils.runConcurrently(new ContextPropagatingCallable<Void>(new Callable<Void>(){
    public Void call() throws Exception {
      assertTrue(Context.isContextSet());
      assertSame(context,Context.get());
      return null;
    }
  }
),1);
}
