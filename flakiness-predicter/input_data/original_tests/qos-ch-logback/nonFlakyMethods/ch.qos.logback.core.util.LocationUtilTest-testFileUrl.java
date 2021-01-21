@Test public void testFileUrl() throws Exception {
  File file=File.createTempFile("testResource",".txt");
  file.deleteOnExit();
  PrintWriter writer=new PrintWriter(file);
  writer.println(TEST_PATTERN);
  writer.close();
  URL url=file.toURI().toURL();
  validateResource(url);
}
