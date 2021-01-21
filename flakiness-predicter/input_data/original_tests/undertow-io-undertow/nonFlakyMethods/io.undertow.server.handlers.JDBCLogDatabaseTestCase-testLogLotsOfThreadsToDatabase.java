@Test public void testLogLotsOfThreadsToDatabase() throws IOException, InterruptedException, ExecutionException, SQLException {
  JDBCLogHandler logHandler=new JDBCLogHandler(HELLO_HANDLER,DefaultServer.getWorker(),"combined",ds);
  CompletionLatchHandler latchHandler;
  DefaultServer.setRootHandler(latchHandler=new CompletionLatchHandler(NUM_REQUESTS * NUM_THREADS,logHandler));
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
  logHandler.awaitWrittenForTest();
  Connection conn=null;
  Statement statement=null;
  try {
    conn=ds.getConnection();
    statement=conn.createStatement();
    ResultSet resultDatabase=conn.createStatement().executeQuery("SELECT COUNT(*) FROM PUBLIC.ACCESS;");
    resultDatabase.next();
    Assert.assertEquals(resultDatabase.getInt(1),NUM_REQUESTS * NUM_THREADS);
  }
  finally {
    if (statement != null) {
      statement.close();
    }
    if (conn != null) {
      conn.close();
    }
  }
}
