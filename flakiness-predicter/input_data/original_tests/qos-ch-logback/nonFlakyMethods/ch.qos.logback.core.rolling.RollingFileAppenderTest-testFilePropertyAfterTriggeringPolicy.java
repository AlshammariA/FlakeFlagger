@Test public void testFilePropertyAfterTriggeringPolicy(){
  rfa.setContext(context);
  rfa.setTriggeringPolicy(new SizeBasedTriggeringPolicy<Object>());
  rfa.setFile("x");
  StatusChecker statusChecker=new StatusChecker(context.getStatusManager());
  statusChecker.assertContainsMatch(Status.ERROR,"File property must be set before any triggeringPolicy ");
}
