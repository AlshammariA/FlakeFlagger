@Test public void testSettingHeader() throws IOException {
  DefaultServer.setRootHandler(Handlers.setAttribute(ResponseCodeHandler.HANDLE_200,"%{o,Foo}","%U-%{q,p1}",SetAttributeHandler.class.getClassLoader()));
  TestHttpClient client=new TestHttpClient();
  try {
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path/a");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    Assert.assertEquals("/path/a-",result.getHeaders("foo")[0].getValue());
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path/a?p1=someQp");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    Assert.assertEquals("/path/a-someQp",result.getHeaders("foo")[0].getValue());
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path/a?p1=someQp&p1=value2");
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    Assert.assertEquals("/path/a-[someQp, value2]",result.getHeaders("foo")[0].getValue());
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
