@Test public void testAjpParsing() throws IOException {
  final ByteBuffer buffer=AjpParsingUnitTestCase.buffer.duplicate();
  HttpServerExchange result=new HttpServerExchange(null);
  final AjpRequestParseState state=new AjpRequestParseState();
  AJP_REQUEST_PARSER.parse(buffer,state,result);
  Assert.assertEquals(165,state.dataSize);
  Assert.assertTrue(state.isComplete());
  Assert.assertEquals(0,buffer.remaining());
  testResult(result);
}
