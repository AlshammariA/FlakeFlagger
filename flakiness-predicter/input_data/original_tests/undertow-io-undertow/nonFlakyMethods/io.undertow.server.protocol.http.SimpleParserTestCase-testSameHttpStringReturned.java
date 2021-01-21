@Test public void testSameHttpStringReturned(){
  byte[] in="GET\thttp://www.somehost.net/somepath\tHTTP/1.1\nHost: \t www.somehost.net\nAccept-Charset:\tsome\n \t  value\n\r\n".getBytes();
  final ParseState context1=new ParseState();
  HttpServerExchange result1=new HttpServerExchange(null);
  HttpRequestParser.instance(OptionMap.EMPTY).handle(ByteBuffer.wrap(in),context1,result1);
  final ParseState context2=new ParseState();
  HttpServerExchange result2=new HttpServerExchange(null);
  HttpRequestParser.instance(OptionMap.EMPTY).handle(ByteBuffer.wrap(in),context2,result2);
  Assert.assertSame(result1.getProtocol(),result2.getProtocol());
  Assert.assertSame(result1.getRequestMethod(),result2.getRequestMethod());
  for (  final HttpString header : result1.getRequestHeaders().getHeaderNames()) {
    boolean found=false;
    for (    final HttpString header2 : result1.getRequestHeaders().getHeaderNames()) {
      if (header == header2) {
        found=true;
        break;
      }
    }
    if (header.equals(Headers.HOST)) {
      Assert.assertSame(Headers.HOST,header);
    }
    Assert.assertTrue("Could not found header " + header,found);
  }
}
