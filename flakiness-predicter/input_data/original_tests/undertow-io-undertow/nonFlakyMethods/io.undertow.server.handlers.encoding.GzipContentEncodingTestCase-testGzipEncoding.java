/** 
 * Tests the use of the deflate contentent encoding
 * @throws java.io.IOException
 */
@Test public void testGzipEncoding() throws IOException {
  runTest("Hello World");
}
