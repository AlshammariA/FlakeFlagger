@Test public void withGZCompression_FileSet_NoRestart_5() throws Exception {
  generic("test5","toto.log",FIRST_PHASE_ONLY,".gz");
}
