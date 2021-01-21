@Test public void testEncodedSlashAllowed(){
  byte[] in="GET /somepath%2fotherPath HTTP/1.1\r\n\r\n".getBytes();
  final ParseState context=new ParseState();
  HttpServerExchange result=new HttpServerExchange(null);
  HttpRequestParser.instance(OptionMap.create(UndertowOptions.ALLOW_ENCODED_SLASH,true)).handle(ByteBuffer.wrap(in),context,result);
  Assert.assertSame(Methods.GET,result.getRequestMethod());
  Assert.assertEquals("/somepath/otherPath",result.getRequestPath());
  Assert.assertEquals("/somepath%2fotherPath",result.getRequestURI());
}
