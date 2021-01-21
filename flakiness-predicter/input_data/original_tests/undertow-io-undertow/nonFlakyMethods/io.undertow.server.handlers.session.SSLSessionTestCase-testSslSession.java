@Test public void testSslSession() throws IOException {
  TestHttpClient client=new TestHttpClient();
  try {
    final SslSessionConfig sessionConfig=new SslSessionConfig();
    final SessionAttachmentHandler handler=new SessionAttachmentHandler(new InMemorySessionManager(),sessionConfig).setNext(new HttpHandler(){
      @Override public void handleRequest(      final HttpServerExchange exchange) throws Exception {
        final SessionManager manager=exchange.getAttachment(SessionManager.ATTACHMENT_KEY);
        Session session=manager.getSession(exchange,sessionConfig);
        if (session == null) {
          session=manager.createSession(exchange,sessionConfig);
          session.setAttribute(COUNT,0);
        }
        Integer count=(Integer)session.getAttribute(COUNT);
        exchange.getResponseHeaders().add(new HttpString(COUNT),count.toString());
        session.setAttribute(COUNT,++count);
      }
    }
);
    DefaultServer.startSSLServer();
    client.setSSLContext(DefaultServer.getClientSSLContext());
    DefaultServer.setRootHandler(handler);
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerSSLAddress() + "/notamatchingpath");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    Header[] header=result.getHeaders(COUNT);
    Assert.assertEquals("0",header[0].getValue());
    get=new HttpGet(DefaultServer.getDefaultServerSSLAddress() + "/notamatchingpath");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    header=result.getHeaders(COUNT);
    Assert.assertEquals("1",header[0].getValue());
    get=new HttpGet(DefaultServer.getDefaultServerSSLAddress() + "/notamatchingpath");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    header=result.getHeaders(COUNT);
    Assert.assertEquals("2",header[0].getValue());
    Assert.assertEquals(0,client.getCookieStore().getCookies().size());
  }
  finally {
    DefaultServer.stopSSLServer();
    client.getConnectionManager().shutdown();
  }
}
