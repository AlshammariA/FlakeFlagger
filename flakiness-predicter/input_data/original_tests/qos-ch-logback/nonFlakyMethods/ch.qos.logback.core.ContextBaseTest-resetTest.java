@Test public void resetTest(){
  context.setName("hello");
  context.putProperty("keyA","valA");
  context.putObject("keyA","valA");
  assertEquals("valA",context.getProperty("keyA"));
  assertEquals("valA",context.getObject("keyA"));
  MockLifeCycleComponent component=new MockLifeCycleComponent();
  context.register(component);
  assertSame(component,lifeCycleManager.getLastComponent());
  context.reset();
  assertNull(context.getProperty("keyA"));
  assertNull(context.getObject("keyA"));
  assertTrue(lifeCycleManager.isReset());
}
