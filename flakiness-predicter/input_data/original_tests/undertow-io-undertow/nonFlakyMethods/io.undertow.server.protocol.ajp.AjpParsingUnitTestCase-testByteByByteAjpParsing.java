@Test public void testByteByByteAjpParsing() throws IOException {
  final ByteBuffer buffer=AjpParsingUnitTestCase.buffer.duplicate();
  HttpServerExchange result=new HttpServerExchange(null);
  final AjpRequestParseState state=new AjpRequestParseState();
  int limit=buffer.limit();
  for (int i=1; i <= limit; ++i) {
    buffer.limit(i);
    AJP_REQUEST_PARSER.parse(buffer,state,result);
  }
  Assert.assertEquals(165,state.dataSize);
  Assert.assertTrue(state.isComplete());
  testResult(result);
}
