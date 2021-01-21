@Test public void testHttpContinueAccepted() throws IOException {
  accept=true;
  String message="My HTTP Request!";
  HttpParams httpParams=new BasicHttpParams();
  httpParams.setParameter("http.protocol.wait-for-continue",Integer.MAX_VALUE);
  TestHttpClient client=new TestHttpClient();
  client.setParams(httpParams);
  try {
    HttpPost post=new HttpPost(DefaultServer.getDefaultServerURL() + "/path");
    post.addHeader("Expect","100-continue");
    post.setEntity(new StringEntity(message));
    HttpResponse result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertEquals(message,HttpClientUtils.readResponse(result));
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
