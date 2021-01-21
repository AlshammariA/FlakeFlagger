@Test public void testLogLotsOfThreads() throws IOException, InterruptedException, ExecutionException {
  File directory=logDirectory;
  File logFileName=new File(directory,"server2.log");
  DefaultAccessLogReceiver logReceiver=new DefaultAccessLogReceiver(DefaultServer.getWorker(),directory,"server2");
  CompletionLatchHandler latchHandler;
  DefaultServer.setRootHandler(latchHandler=new CompletionLatchHandler(NUM_REQUESTS * NUM_THREADS,new AccessLogHandler(HELLO_HANDLER,logReceiver,"REQ %{i,test-header}",AccessLogFileTestCase.class.getClassLoader())));
  ExecutorService executor=Executors.newFixedThreadPool(NUM_THREADS);
  try {
    final List<Future<?>> futures=new ArrayList<Future<?>>();
    for (int i=0; i < NUM_THREADS; ++i) {
      final int threadNo=i;
      futures.add(executor.submit(new Runnable(){
        @Override public void run(){
          TestHttpClient client=new TestHttpClient();
          try {
            for (int i=0; i < NUM_REQUESTS; ++i) {
              HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
              get.addHeader("test-header","thread-" + threadNo + "-request-"+ i);
              HttpResponse result=client.execute(get);
              Assert.assertEquals(200,result.getStatusLine().getStatusCode());
              final String response=HttpClientUtils.readResponse(result);
              Assert.assertEquals("Hello",response);
            }
          }
 catch (          IOException e) {
            throw new RuntimeException(e);
          }
 finally {
            client.getConnectionManager().shutdown();
          }
        }
      }
));
    }
    for (    Future<?> future : futures) {
      future.get();
    }
  }
  finally {
    executor.shutdown();
  }
  latchHandler.await();
  logReceiver.awaitWrittenForTest();
  String completeLog=FileUtils.readFile(logFileName);
  for (int i=0; i < NUM_THREADS; ++i) {
    for (int j=0; j < NUM_REQUESTS; ++j) {
      Assert.assertTrue(completeLog.contains("REQ thread-" + i + "-request-"+ j));
    }
  }
}
