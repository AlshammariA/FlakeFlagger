@Test public void noCompression_FileSet_StopRestart_WithLongWait_4B() throws IOException {
  defaultTest("test4B","test4B","",FILE_OPTION_SET,WITH_RESTART_AND_LONG_WAIT);
}
