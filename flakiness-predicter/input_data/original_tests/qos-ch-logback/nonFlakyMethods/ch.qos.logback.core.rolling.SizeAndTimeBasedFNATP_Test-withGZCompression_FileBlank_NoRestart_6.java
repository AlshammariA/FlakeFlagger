@Test public void withGZCompression_FileBlank_NoRestart_6() throws Exception {
  generic("test6",null,FIRST_PHASE_ONLY,".gz");
}
