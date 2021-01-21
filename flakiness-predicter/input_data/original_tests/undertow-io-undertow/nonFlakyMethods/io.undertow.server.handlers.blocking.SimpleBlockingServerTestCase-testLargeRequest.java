@Test public void testLargeRequest() throws IOException {
  message=null;
  final StringBuilder messageBuilder=new StringBuilder(6919638);
  for (int i=0; i < 6919638; ++i) {
    messageBuilder.append("+");
  }
  TestHttpClient client=new TestHttpClient();
  try {
    HttpPost post=new HttpPost(DefaultServer.getDefaultServerURL() + "/path");
    post.setEntity(new StringEntity(messageBuilder.toString()));
    HttpResponse result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertTrue(messageBuilder.toString().equals(HttpClientUtils.readResponse(result)));
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
