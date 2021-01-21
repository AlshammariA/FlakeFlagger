@Test public void test3() throws Exception {
  Compressor compressor=new Compressor(CompressionMode.ZIP);
  compressor.setContext(context);
  compressor.compress(CoreTestConstants.TEST_SRC_PREFIX + "input/compress3.txt",CoreTestConstants.OUTPUT_DIR_PREFIX + "compress3.txt","compress3.txt");
  StatusChecker checker=new StatusChecker(context);
  assertTrue(checker.isErrorFree(0));
}
