@Test public void noCompression_FileSet_NoRestart_1() throws InterruptedException, ExecutionException, IOException {
  generic("test1","toto.log",FIRST_PHASE_ONLY,DEFAULT_COMPRESSION_SUFFIX);
}
