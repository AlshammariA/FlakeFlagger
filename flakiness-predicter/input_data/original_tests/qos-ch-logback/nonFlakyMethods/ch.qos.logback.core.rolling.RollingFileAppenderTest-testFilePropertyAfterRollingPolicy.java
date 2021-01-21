@Test public void testFilePropertyAfterRollingPolicy(){
  rfa.setContext(context);
  rfa.setRollingPolicy(tbrp);
  rfa.setFile("x");
  StatusPrinter.print(context);
  StatusChecker statusChecker=new StatusChecker(context.getStatusManager());
  statusChecker.assertContainsMatch(Status.ERROR,"File property must be set before any triggeringPolicy ");
}
