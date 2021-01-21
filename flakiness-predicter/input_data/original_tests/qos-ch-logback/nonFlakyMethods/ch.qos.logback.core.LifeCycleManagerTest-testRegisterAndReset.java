@Test public void testRegisterAndReset(){
  MockLifeCycleComponent component=new MockLifeCycleComponent();
  manager.register(component);
  component.start();
  manager.reset();
  assertFalse(component.isStarted());
}
