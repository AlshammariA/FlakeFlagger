@Test public void testResumeWritesFixedLength() throws IOException {
  DefaultServer.setRootHandler(new HttpHandler(){
    @Override public void handleRequest(    final HttpServerExchange exchange) throws Exception {
      exchange.addResponseWrapper(new ReturnZeroWrapper());
      exchange.getResponseHeaders().put(Headers.CONTENT_LENGTH,HELLO_WORLD.length());
      exchange.getResponseSender().send(HELLO_WORLD);
    }
  }
);
  TestHttpClient client=new TestHttpClient();
  try {
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
