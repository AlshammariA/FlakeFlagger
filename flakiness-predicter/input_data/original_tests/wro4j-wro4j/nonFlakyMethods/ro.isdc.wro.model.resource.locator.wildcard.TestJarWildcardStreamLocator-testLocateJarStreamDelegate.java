@Test public void testLocateJarStreamDelegate() throws IOException {
  final InputStream is=jarStreamLocator.locateStream("classpath:com/test/app/*.js",new File("src/test/resources/"));
  final String content=IOUtils.readLines(is).get(0);
  assertTrue(content.contains("1.js"));
  assertTrue(content.contains("2.js"));
  assertTrue(content.contains("3.js"));
  assertTrue(!content.contains("1.css"));
  IOUtils.closeQuietly(is);
}
