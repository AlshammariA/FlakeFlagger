@Test public void testHeadRequests() throws IOException {
  message="My HTTP Request!";
  TestHttpClient client=new TestHttpClient();
  HttpHead head=new HttpHead(DefaultServer.getDefaultServerURL() + "/path");
  try {
    for (int i=0; i < 3; ++i) {
      HttpResponse result=client.execute(head);
      Assert.assertEquals(200,result.getStatusLine().getStatusCode());
      Assert.assertEquals("",HttpClientUtils.readResponse(result));
      Assert.assertEquals(message.length() + "",result.getFirstHeader(Headers.CONTENT_LENGTH_STRING).getValue());
    }
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
