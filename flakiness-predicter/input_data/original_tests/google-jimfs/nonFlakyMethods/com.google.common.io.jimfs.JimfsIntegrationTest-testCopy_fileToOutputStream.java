@Test public void testCopy_fileToOutputStream() throws IOException {
  byte[] bytes=preFilledBytes(512);
  Files.write(path("/test"),bytes);
  ByteArrayOutputStream out=new ByteArrayOutputStream();
  Files.copy(path("/test"),out);
  assertArrayEquals(bytes,out.toByteArray());
  try {
    Files.copy(path("/foo"),path("/bar"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo",expected.getMessage());
  }
}
