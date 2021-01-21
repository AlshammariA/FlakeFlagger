@Test public void testDateHandler() throws IOException, InterruptedException {
  HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
  TestHttpClient client=new TestHttpClient();
  try {
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Header date=result.getHeaders("Date")[0];
    final long firstDate=DateUtils.parseDate(date.getValue()).getTime();
    Assert.assertTrue((firstDate + 3000) > System.currentTimeMillis());
    Assert.assertTrue(System.currentTimeMillis() > firstDate);
    HttpClientUtils.readResponse(result);
    Thread.sleep(1500);
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    date=result.getHeaders("Date")[0];
    final long secondDate=DateUtils.parseDate(date.getValue()).getTime();
    Assert.assertTrue((secondDate + 2000) > System.currentTimeMillis());
    Assert.assertTrue(System.currentTimeMillis() >= secondDate);
    Assert.assertTrue(secondDate > firstDate);
    HttpClientUtils.readResponse(result);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
