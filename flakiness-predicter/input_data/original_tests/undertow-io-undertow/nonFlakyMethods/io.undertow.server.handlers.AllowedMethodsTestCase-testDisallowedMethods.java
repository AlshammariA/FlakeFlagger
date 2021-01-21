@Test public void testDisallowedMethods() throws IOException {
  TestHttpClient client=new TestHttpClient();
  try {
    final DisallowedMethodsHandler handler=new DisallowedMethodsHandler(ResponseCodeHandler.HANDLE_200,Methods.GET);
    DefaultServer.setRootHandler(handler);
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(405,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    HttpPost post=new HttpPost(DefaultServer.getDefaultServerURL() + "/path");
    post.setEntity(new StringEntity("foo"));
    result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
