@Test public void verifyRecuperationAfterFailure() throws Exception {
  File file=new File(CoreTestConstants.OUTPUT_DIR_PREFIX + "resilient" + diff+ ".log");
  ResilientFileOutputStream rfos=new ResilientFileOutputStream(file,true);
  rfos.setContext(context);
  ResilientFileOutputStream spy=spy(rfos);
  spy.write("a".getBytes());
  spy.flush();
  spy.getChannel().close();
  spy.write("b".getBytes());
  spy.flush();
  Thread.sleep(RecoveryCoordinator.BACKOFF_COEFFICIENT_MIN + 10);
  spy.write("c".getBytes());
  spy.flush();
  verify(spy).openNewOutputStream();
}
