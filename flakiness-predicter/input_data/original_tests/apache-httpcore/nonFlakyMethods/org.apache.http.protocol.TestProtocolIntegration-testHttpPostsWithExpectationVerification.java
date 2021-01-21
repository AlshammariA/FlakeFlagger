/** 
 * This test case executes a series of simple POST requests that do not meet the target server expectations.
 */
@Test public void testHttpPostsWithExpectationVerification() throws Exception {
  int reqNo=3;
  this.server.registerHandler("*",new HttpRequestHandler(){
    public void handle(    final HttpRequest request,    final HttpResponse response,    final HttpContext context) throws HttpException, IOException {
      StringEntity outgoing=new StringEntity("No content");
      response.setEntity(outgoing);
    }
  }
);
  this.server.setExpectationVerifier(new HttpExpectationVerifier(){
    public void verify(    final HttpRequest request,    final HttpResponse response,    final HttpContext context) throws HttpException {
      Header someheader=request.getFirstHeader("Secret");
      if (someheader != null) {
        int secretNumber;
        try {
          secretNumber=Integer.parseInt(someheader.getValue());
        }
 catch (        NumberFormatException ex) {
          response.setStatusCode(HttpStatus.SC_BAD_REQUEST);
          return;
        }
        if (secretNumber < 2) {
          response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
          ByteArrayEntity outgoing=new ByteArrayEntity(EncodingUtils.getAsciiBytes("Wrong secret number"));
          response.setEntity(outgoing);
        }
      }
    }
  }
);
  this.server.start();
  this.client.getParams().setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE,true);
  DefaultHttpClientConnection conn=new DefaultHttpClientConnection();
  HttpHost host=new HttpHost("localhost",this.server.getPort());
  try {
    for (int r=0; r < reqNo; r++) {
      if (!conn.isOpen()) {
        Socket socket=new Socket(host.getHostName(),host.getPort());
        conn.bind(socket,this.client.getParams());
      }
      BasicHttpEntityEnclosingRequest post=new BasicHttpEntityEnclosingRequest("POST","/");
      post.addHeader("Secret",Integer.toString(r));
      ByteArrayEntity outgoing=new ByteArrayEntity(EncodingUtils.getAsciiBytes("No content"));
      post.setEntity(outgoing);
      HttpResponse response=this.client.execute(post,host,conn);
      HttpEntity entity=response.getEntity();
      Assert.assertNotNull(entity);
      EntityUtils.consume(entity);
      if (r < 2) {
        Assert.assertEquals(HttpStatus.SC_EXPECTATION_FAILED,response.getStatusLine().getStatusCode());
      }
 else {
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
      }
      if (!this.client.keepAlive(response)) {
        conn.close();
      }
    }
    HttpConnectionMetrics cm=conn.getMetrics();
    Assert.assertEquals(reqNo,cm.getRequestCount());
    Assert.assertEquals(reqNo,cm.getResponseCount());
  }
  finally {
    conn.close();
    this.server.shutdown();
  }
}
