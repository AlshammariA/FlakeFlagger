@Test public void testQueryParams(){
  byte[] in="GET\thttp://www.somehost.net/somepath?a=b&b=c&d&e&f=\tHTTP/1.1\nHost: \t www.somehost.net\nOtherHeader:\tsome\n \t  value\n\r\n".getBytes();
  final ParseState context=new ParseState();
  HttpServerExchange result=new HttpServerExchange(null);
  HttpRequestParser.instance(OptionMap.EMPTY).handle(ByteBuffer.wrap(in),context,result);
  Assert.assertEquals("/somepath",result.getRelativePath());
  Assert.assertEquals("http://www.somehost.net/somepath",result.getRequestURI());
  Assert.assertEquals("a=b&b=c&d&e&f=",result.getQueryString());
  Assert.assertEquals("b",result.getQueryParameters().get("a").getFirst());
  Assert.assertEquals("c",result.getQueryParameters().get("b").getFirst());
  Assert.assertEquals("",result.getQueryParameters().get("d").getFirst());
  Assert.assertEquals("",result.getQueryParameters().get("e").getFirst());
  Assert.assertEquals("",result.getQueryParameters().get("f").getFirst());
}
