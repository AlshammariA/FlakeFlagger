@Test public void testHttpContinueRejected() throws IOException {
  accept=false;
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
    Assert.assertEquals(417,result.getStatusLine().getStatusCode());
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
