@Test public void testWithUpdatePeriodSet(){
  Context.get().getConfig().setCacheUpdatePeriod(1);
  Context.get().getConfig().setModelUpdatePeriod(1);
  testSuccessfulCreation();
}
