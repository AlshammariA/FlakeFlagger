public void testFileContains() throws Exception {
  assertFileContains("test.txt","text/plain","AE502DBEA2C411DEBD340AD156D89593");
  assertFileContains("test.rtf","application/rtf","quick brown fox");
}
