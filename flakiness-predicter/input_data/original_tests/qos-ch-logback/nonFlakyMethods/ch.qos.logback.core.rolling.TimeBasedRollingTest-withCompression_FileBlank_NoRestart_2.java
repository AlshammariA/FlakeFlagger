@Test public void withCompression_FileBlank_NoRestart_2() throws IOException {
  defaultTest("test2","test2",".gz",FILE_OPTION_BLANK,NO_RESTART);
}
