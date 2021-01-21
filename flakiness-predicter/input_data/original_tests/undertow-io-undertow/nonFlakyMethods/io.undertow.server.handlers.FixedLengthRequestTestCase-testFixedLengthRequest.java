@Test public void testFixedLengthRequest() throws IOException {
  connection=null;
  HttpPost post=new HttpPost(DefaultServer.getDefaultServerURL() + "/path");
  TestHttpClient client=new TestHttpClient();
  try {
    generateMessage(1);
    post.setEntity(new StringEntity(message));
    HttpResponse result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    generateMessage(1000);
    post.setEntity(new StringEntity(message));
    result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
