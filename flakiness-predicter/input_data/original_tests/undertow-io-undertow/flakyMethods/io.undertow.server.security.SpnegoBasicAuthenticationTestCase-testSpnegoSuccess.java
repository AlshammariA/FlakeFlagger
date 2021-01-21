@Test public void testSpnegoSuccess() throws Exception {
  setAuthenticationChain();
  final TestHttpClient client=new TestHttpClient();
  HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL());
  HttpResponse result=client.execute(get);
  assertEquals(401,result.getStatusLine().getStatusCode());
  Header[] values=result.getHeaders(WWW_AUTHENTICATE.toString());
  String header=getAuthHeader(NEGOTIATE,values);
  assertEquals(NEGOTIATE.toString(),header);
  HttpClientUtils.readResponse(result);
  Subject clientSubject=login("jduke","theduke".toCharArray());
  Subject.doAs(clientSubject,new PrivilegedExceptionAction<Void>(){
    @Override public Void run() throws Exception {
      GSSManager gssManager=GSSManager.getInstance();
      GSSName serverName=gssManager.createName("HTTP/" + DefaultServer.getDefaultServerAddress().getHostString(),null);
      GSSContext context=gssManager.createContext(serverName,SPNEGO,null,GSSContext.DEFAULT_LIFETIME);
      byte[] token=new byte[0];
      boolean gotOur200=false;
      while (!context.isEstablished()) {
        token=context.initSecContext(token,0,token.length);
        if (token != null && token.length > 0) {
          HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL());
          get.addHeader(AUTHORIZATION.toString(),NEGOTIATE + " " + FlexBase64.encodeString(token,false));
          HttpResponse result=client.execute(get);
          Header[] headers=result.getHeaders(WWW_AUTHENTICATE.toString());
          if (headers.length > 0) {
            String header=getAuthHeader(NEGOTIATE,headers);
            byte[] headerBytes=header.getBytes("UTF-8");
            token=FlexBase64.decode(headerBytes,NEGOTIATE.toString().length() + 1,headerBytes.length).array();
          }
          if (result.getStatusLine().getStatusCode() == 200) {
            Header[] values=result.getHeaders("ProcessedBy");
            assertEquals(1,values.length);
            assertEquals("ResponseHandler",values[0].getValue());
            HttpClientUtils.readResponse(result);
            assertSingleNotificationType(EventType.AUTHENTICATED);
            gotOur200=true;
          }
 else           if (result.getStatusLine().getStatusCode() == 401) {
            assertTrue("We did get a header.",headers.length > 0);
            HttpClientUtils.readResponse(result);
          }
 else {
            fail(String.format("Unexpected status code %d",result.getStatusLine().getStatusCode()));
          }
        }
      }
      assertTrue(gotOur200);
      assertTrue(context.isEstablished());
      return null;
    }
  }
);
}
