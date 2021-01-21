@Test public void testOneCharacterAtATime(){
  byte[] in=DATA.getBytes();
  final ResponseParseState context=new ResponseParseState();
  HttpResponseBuilder result=new HttpResponseBuilder();
  ByteBuffer buffer=ByteBuffer.wrap(in);
  buffer.limit(1);
  while (context.state != ResponseParseState.PARSE_COMPLETE) {
    HttpResponseParser.INSTANCE.handle(buffer,context,result);
    buffer.limit(buffer.limit() + 1);
  }
  runAssertions(result,context);
}
