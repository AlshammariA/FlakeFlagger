@Test public void testWriteFile_succeeds() throws IOException {
  Files.createFile(path("/test"));
  Files.write(path("/test"),new byte[]{0,1,2,3});
}
