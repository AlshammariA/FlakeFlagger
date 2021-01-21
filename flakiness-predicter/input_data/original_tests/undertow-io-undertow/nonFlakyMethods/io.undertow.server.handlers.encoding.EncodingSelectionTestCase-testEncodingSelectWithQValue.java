/** 
 * Tests encoding selection with a qvalue
 * @throws IOException
 */
@Test public void testEncodingSelectWithQValue() throws IOException {
  TestHttpClient client=new TestHttpClient();
  try {
    final EncodingHandler handler=new EncodingHandler(new ContentEncodingRepository().addEncodingHandler("compress",ContentEncodingProvider.IDENTITY,100).addEncodingHandler("bzip",ContentEncodingProvider.IDENTITY,50)).setNext(new HttpHandler(){
      @Override public void handleRequest(      final HttpServerExchange exchange) throws Exception {
        exchange.getResponseSender().send("hi");
      }
    }
);
    DefaultServer.setRootHandler(handler);
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ACCEPT_ENCODING_STRING,"bzip, compress;q=0.6");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Header[] header=result.getHeaders(HEADER);
    Assert.assertEquals("bzip",header[0].getValue());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ACCEPT_ENCODING_STRING,"*;q=0.00");
    result=client.execute(get);
    Assert.assertEquals(406,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ACCEPT_ENCODING_STRING,"*;q=0.00 bzip");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    header=result.getHeaders(HEADER);
    Assert.assertEquals("bzip",header[0].getValue());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ACCEPT_ENCODING_STRING,"*;q=0.00 bzip;q=0.3");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    header=result.getHeaders(HEADER);
    Assert.assertEquals("bzip",header[0].getValue());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ACCEPT_ENCODING_STRING,"compress;q=0.1 bzip;q=0.05");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    header=result.getHeaders(HEADER);
    Assert.assertEquals("compress",header[0].getValue());
    HttpClientUtils.readResponse(result);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    get.setHeader(Headers.ACCEPT_ENCODING_STRING,"compress;q=0.1, bzip;q=1.000");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    header=result.getHeaders(HEADER);
    Assert.assertEquals("bzip",header[0].getValue());
    HttpClientUtils.readResponse(result);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
