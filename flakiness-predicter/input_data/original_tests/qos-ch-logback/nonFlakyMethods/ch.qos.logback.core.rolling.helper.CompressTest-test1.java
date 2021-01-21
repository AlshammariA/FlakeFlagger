@Test public void test1() throws Exception {
  Compressor compressor=new Compressor(CompressionMode.GZ);
  compressor.setContext(context);
  compressor.compress(CoreTestConstants.TEST_SRC_PREFIX + "input/compress1.txt",CoreTestConstants.OUTPUT_DIR_PREFIX + "compress1.txt.gz",null);
  StatusChecker checker=new StatusChecker(context);
  assertTrue(checker.isErrorFree(0));
  assertTrue(Compare.gzCompare(CoreTestConstants.OUTPUT_DIR_PREFIX + "compress1.txt.gz",CoreTestConstants.TEST_SRC_PREFIX + "witness/compress1.txt.gz"));
}
