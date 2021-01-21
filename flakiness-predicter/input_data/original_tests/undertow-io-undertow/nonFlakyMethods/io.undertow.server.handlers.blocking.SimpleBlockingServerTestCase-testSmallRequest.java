@Test public void testSmallRequest() throws IOException {
  message=null;
  TestHttpClient client=new TestHttpClient();
  try {
    HttpPost post=new HttpPost(DefaultServer.getDefaultServerURL() + "/path");
    post.setEntity(new StringEntity("a"));
    HttpResponse result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertTrue("a".equals(HttpClientUtils.readResponse(result)));
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
