@Test public void testWithValidFolder() throws IOException {
  final File folder=new File(ClassLoader.getSystemResource("").getFile());
  locator.locateStream("/resource/*.css",folder);
}
