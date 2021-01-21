@Test public void test2() throws Exception {
  Compressor compressor=new Compressor(CompressionMode.GZ);
  compressor.setContext(context);
  compressor.compress(CoreTestConstants.TEST_SRC_PREFIX + "input/compress2.txt",CoreTestConstants.OUTPUT_DIR_PREFIX + "compress2.txt",null);
  StatusChecker checker=new StatusChecker(context);
  assertTrue(checker.isErrorFree(0));
  assertTrue(Compare.gzCompare(CoreTestConstants.OUTPUT_DIR_PREFIX + "compress2.txt.gz",CoreTestConstants.TEST_SRC_PREFIX + "witness/compress2.txt.gz"));
}
