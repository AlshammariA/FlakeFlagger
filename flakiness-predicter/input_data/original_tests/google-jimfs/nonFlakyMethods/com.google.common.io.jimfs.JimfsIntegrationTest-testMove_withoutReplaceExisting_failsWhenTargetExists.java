@Test public void testMove_withoutReplaceExisting_failsWhenTargetExists() throws IOException {
  byte[] bytes=preFilledBytes(50);
  Files.write(path("/test"),bytes);
  Object testKey=getFileKey("/test");
  Files.createFile(path("/bar"));
  try {
    Files.move(path("/test"),path("/bar"),ATOMIC_MOVE);
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/bar",expected.getMessage());
  }
  assertThat("/test").containsBytes(bytes).and().attribute("fileKey").isEqualTo(testKey);
  Files.delete(path("/bar"));
  Files.createDirectory(path("/bar"));
  try {
    Files.move(path("/test"),path("/bar"),ATOMIC_MOVE);
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/bar",expected.getMessage());
  }
  assertThat("/test").containsBytes(bytes).and().attribute("fileKey").isEqualTo(testKey);
}
