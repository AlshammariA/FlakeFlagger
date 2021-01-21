@Test public void testRewrite() throws IOException {
  DefaultServer.setRootHandler(rewrite("regex['/somePath/(.*)']","/otherPath/$1",getClass().getClassLoader(),path().addPath("/otherPath",new InfoHandler()).addPath("/relative",rewrite("path-template['/foo/{bar}/{woz}']","/foo?bar=${bar}&woz=${woz}",getClass().getClassLoader(),new InfoHandler()))));
  TestHttpClient client=new TestHttpClient();
  try {
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/relative/foo/a/b");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    String response=HttpClientUtils.readResponse(result);
    Assert.assertEquals("URI: /relative/foo?bar=a&woz=b relative: /foo QS:?bar=a&woz=b bar: a woz: b",response);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/somePath/foo/a/b");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    response=HttpClientUtils.readResponse(result);
    Assert.assertEquals("URI: /otherPath/foo/a/b relative: /foo/a/b QS:",response);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/somePath/foo?a=b");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    response=HttpClientUtils.readResponse(result);
    Assert.assertEquals("URI: /otherPath/foo relative: /foo QS:a=b a: b",response);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
