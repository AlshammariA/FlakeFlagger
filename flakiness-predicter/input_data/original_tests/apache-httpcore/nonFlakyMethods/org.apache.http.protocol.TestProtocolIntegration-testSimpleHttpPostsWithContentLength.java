/** 
 * This test case executes a series of simple POST requests with content length delimited content.
 */
@Test public void testSimpleHttpPostsWithContentLength() throws Exception {
  int reqNo=20;
  Random rnd=new Random();
  List<byte[]> testData=new ArrayList<byte[]>(reqNo);
  for (int i=0; i < reqNo; i++) {
    int size=rnd.nextInt(5000);
    byte[] data=new byte[size];
    rnd.nextBytes(data);
    testData.add(data);
  }
  this.server.registerHandler("*",new HttpRequestHandler(){
    public void handle(    final HttpRequest request,    final HttpResponse response,    final HttpContext context) throws HttpException, IOException {
      if (request instanceof HttpEntityEnclosingRequest) {
        HttpEntity incoming=((HttpEntityEnclosingRequest)request).getEntity();
        byte[] data=EntityUtils.toByteArray(incoming);
        ByteArrayEntity outgoing=new ByteArrayEntity(data);
        outgoing.setChunked(false);
        response.setEntity(outgoing);
      }
 else {
        StringEntity outgoing=new StringEntity("No content");
        response.setEntity(outgoing);
      }
    }
  }
);
  this.server.start();
  DefaultHttpClientConnection conn=new DefaultHttpClientConnection();
  HttpHost host=new HttpHost("localhost",this.server.getPort());
  try {
    for (int r=0; r < reqNo; r++) {
      if (!conn.isOpen()) {
        Socket socket=new Socket(host.getHostName(),host.getPort());
        conn.bind(socket,this.client.getParams());
      }
      BasicHttpEntityEnclosingRequest post=new BasicHttpEntityEnclosingRequest("POST","/");
      byte[] data=testData.get(r);
      ByteArrayEntity outgoing=new ByteArrayEntity(data);
      post.setEntity(outgoing);
      HttpResponse response=this.client.execute(post,host,conn);
      byte[] received=EntityUtils.toByteArray(response.getEntity());
      byte[] expected=testData.get(r);
      Assert.assertEquals(expected.length,received.length);
      for (int i=0; i < expected.length; i++) {
        Assert.assertEquals(expected[i],received[i]);
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
