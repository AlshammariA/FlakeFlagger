@Test public void testSenderSetsContentLength() throws IOException {
  HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/fixed");
  TestHttpClient client=new TestHttpClient();
  try {
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
    Header[] header=result.getHeaders(Headers.CONTENT_LENGTH_STRING);
    Assert.assertEquals(1,header.length);
    Assert.assertEquals("" + HELLO_WORLD.length(),header[0].getValue());
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
