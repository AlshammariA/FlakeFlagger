@Test public void gracefulShutdownListenerTestCase() throws IOException, InterruptedException {
  HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
  TestHttpClient client=new TestHttpClient();
  try {
    HttpResponse result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    shutdown.shutdown();
    result=client.execute(get);
    Assert.assertEquals(503,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    shutdown.start();
    result=client.execute(get);
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    CountDownLatch latch=new CountDownLatch(1);
    latch2.set(latch);
    latch1.set(new CountDownLatch(1));
    Thread t=new Thread(new RequestTask());
    t.start();
    latch1.get().await();
    ShutdownListener listener=new ShutdownListener();
    shutdown.shutdown();
    shutdown.addShutdownListener(listener);
    Assert.assertFalse(listener.invoked);
    latch.countDown();
    long end=System.currentTimeMillis() + 5000;
    while (!listener.invoked && System.currentTimeMillis() < end) {
      Thread.sleep(10);
    }
    Assert.assertTrue(listener.invoked);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
