@Test public void testSimpleRequest(){
  byte[] in="GET /somepath HTTP/1.1\r\nHost:   www.somehost.net\r\nOtherHeader: some\r\n    value\r\n\r\n".getBytes();
  runTest(in);
}
