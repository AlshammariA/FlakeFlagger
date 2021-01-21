@Test public void testAsyncSender() throws IOException {
  StringBuilder sb=new StringBuilder(SENDS);
  for (int i=0; i < SENDS; ++i) {
    sb.append("a");
  }
  HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/lots?blocking=false");
  TestHttpClient client=new TestHttpClient();
  try {
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertEquals(sb.toString(),HttpClientUtils.readResponse(result));
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
