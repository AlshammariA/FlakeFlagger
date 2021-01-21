/** 
 * Tests the Origin header is respected when the strictest options are selected
 */
@Test public void testStrictOrigin() throws IOException {
  TestHttpClient client=new TestHttpClient();
  try {
    final OriginHandler handler=new OriginHandler();
    handler.addAllowedOrigins("http://www.mysite.com:80","http://mysite.com:80");
    DefaultServer.setRootHandler(handler);
    handler.setNext(ResponseCodeHandler.HANDLE_200);
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(403,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ORIGIN_STRING,"http://www.mysite.com:80");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ORIGIN_STRING,"http://www.mysite.com:80");
    get.setHeader(Headers.ORIGIN_STRING,"http://mysite.com:80");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ORIGIN_STRING,"http://www.mysite.com:80");
    get.setHeader(Headers.ORIGIN_STRING,"bogus");
    result=client.execute(get);
    Assert.assertEquals(403,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ORIGIN_STRING,"http://www.mysite.com:80");
    get.setHeader(Headers.ORIGIN_STRING,"bogus");
    result=client.execute(get);
    Assert.assertEquals(403,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
