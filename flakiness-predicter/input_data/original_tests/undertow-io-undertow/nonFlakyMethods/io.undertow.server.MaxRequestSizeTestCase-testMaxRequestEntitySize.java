@Test public void testMaxRequestEntitySize() throws IOException {
  OptionMap existing=DefaultServer.getUndertowOptions();
  final TestHttpClient client=new TestHttpClient();
  try {
    HttpPost post=new HttpPost(DefaultServer.getDefaultServerURL() + "/notamatchingpath");
    post.setEntity(new StringEntity(A_MESSAGE));
    post.addHeader(Headers.CONNECTION_STRING,"close");
    HttpResponse result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    OptionMap maxSize=OptionMap.create(UndertowOptions.MAX_ENTITY_SIZE,(long)A_MESSAGE.length() - 1);
    DefaultServer.setUndertowOptions(maxSize);
    post=new HttpPost(DefaultServer.getDefaultServerURL() + "/notamatchingpath");
    post.setEntity(new StringEntity(A_MESSAGE));
    result=client.execute(post);
    Assert.assertEquals(500,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    maxSize=OptionMap.create(UndertowOptions.MAX_HEADER_SIZE,1000);
    DefaultServer.setUndertowOptions(maxSize);
    post=new HttpPost(DefaultServer.getDefaultServerURL() + "/notamatchingpath");
    post.setEntity(new StringEntity(A_MESSAGE));
    post.addHeader(Headers.CONNECTION_STRING,"close");
    result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
  }
  finally {
    DefaultServer.setUndertowOptions(existing);
    client.getConnectionManager().shutdown();
  }
}
