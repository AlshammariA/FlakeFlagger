@Test public void testEmpty() throws ScanException {
  try {
    new TokenStream("").tokenize();
    fail("empty string not allowed");
  }
 catch (  IllegalArgumentException e) {
  }
}
