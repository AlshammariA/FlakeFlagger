@Test public void testChunkedRequest() throws IOException {
  connection=null;
  HttpPost post=new HttpPost(DefaultServer.getDefaultServerURL() + "/path");
  TestHttpClient client=new TestHttpClient();
  try {
    generateMessage(1);
    post.setEntity(new StringEntity(message){
      @Override public long getContentLength(){
        return -1;
      }
    }
);
    HttpResponse result=client.execute(post);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    final Random random=new Random();
    final int seed=random.nextInt();
    System.out.print("Using Seed " + seed);
    random.setSeed(seed);
    for (int i=0; i < 10; ++i) {
      generateMessage(100 * i);
      post.setEntity(new StringEntity(message){
        @Override public long getContentLength(){
          return -1;
        }
        @Override public boolean isChunked(){
          return true;
        }
        @Override public void writeTo(        OutputStream outstream) throws IOException {
          int l=0;
          int i=0;
          while (i <= message.length()) {
            i+=random.nextInt(1000);
            i=Math.min(i,message.length());
            outstream.write(message.getBytes(),l,i - l);
            l=i;
            ++i;
          }
        }
      }
);
      result=client.execute(post);
      Assert.assertEquals(200,result.getStatusLine().getStatusCode());
      HttpClientUtils.readResponse(result);
    }
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
