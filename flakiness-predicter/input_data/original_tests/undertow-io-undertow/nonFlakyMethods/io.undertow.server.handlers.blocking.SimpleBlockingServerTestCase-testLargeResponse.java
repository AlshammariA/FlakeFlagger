@Test public void testLargeResponse() throws IOException {
  final StringBuilder messageBuilder=new StringBuilder(6919638);
  for (int i=0; i < 6919638; ++i) {
    messageBuilder.append("*");
  }
  message=messageBuilder.toString();
  TestHttpClient client=new TestHttpClient();
  try {
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    String resultString=HttpClientUtils.readResponse(result);
    Assert.assertEquals(message.length(),resultString.length());
    Assert.assertTrue(message.equals(resultString));
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path?useSender");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    String resultBody=HttpClientUtils.readResponse(result);
    Assert.assertTrue(message.equals(resultBody));
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path?useFragmentedSender");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    resultBody=HttpClientUtils.readResponse(result);
    Assert.assertTrue(message.equals(resultBody));
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
