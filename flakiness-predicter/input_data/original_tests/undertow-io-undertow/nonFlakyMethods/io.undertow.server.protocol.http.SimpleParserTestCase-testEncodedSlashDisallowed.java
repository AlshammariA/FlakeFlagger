@Test public void testEncodedSlashDisallowed(){
  byte[] in="GET /somepath%2FotherPath HTTP/1.1\r\n\r\n".getBytes();
  final ParseState context=new ParseState();
  HttpServerExchange result=new HttpServerExchange(null);
  HttpRequestParser.instance(OptionMap.EMPTY).handle(ByteBuffer.wrap(in),context,result);
  Assert.assertSame(Methods.GET,result.getRequestMethod());
  Assert.assertEquals("/somepath%2FotherPath",result.getRequestURI());
  Assert.assertEquals("/somepath%2FotherPath",result.getRequestPath());
}
