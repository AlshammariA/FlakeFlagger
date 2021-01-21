@Test public void shouldBeFasterWhenRunningProcessingInParallel() throws Exception {
  final long begin=System.currentTimeMillis();
  victim.setParallelProcessing(false);
  testMojoWithConfigurableWroManagerFactoryWithValidConfigFileSet();
  final long endSerial=System.currentTimeMillis();
  victim.setParallelProcessing(true);
  testMojoWithConfigurableWroManagerFactoryWithValidConfigFileSet();
  final long endParallel=System.currentTimeMillis();
  final long serial=endSerial - begin;
  final long parallel=endParallel - endSerial;
  LOG.info("serial took: {}ms",serial);
  LOG.info("parallel took: {}ms",parallel);
  assertTrue(serial > parallel);
}
