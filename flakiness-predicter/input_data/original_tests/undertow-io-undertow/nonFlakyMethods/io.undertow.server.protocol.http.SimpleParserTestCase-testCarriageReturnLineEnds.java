@Test public void testCarriageReturnLineEnds(){
  byte[] in="GET /somepath HTTP/1.1\rHost:   www.somehost.net\rOtherHeader: some\r    value\r\r\n".getBytes();
  runTest(in);
}
