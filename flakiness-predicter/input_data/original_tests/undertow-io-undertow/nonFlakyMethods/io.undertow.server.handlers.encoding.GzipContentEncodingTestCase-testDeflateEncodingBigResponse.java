@Test public void testDeflateEncodingBigResponse() throws IOException {
  final StringBuilder messageBuilder=new StringBuilder(691963);
  for (int i=0; i < 691963; ++i) {
    messageBuilder.append("*");
  }
  runTest(messageBuilder.toString());
}
