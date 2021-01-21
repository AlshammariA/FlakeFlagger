@Test public void testSingleLogMessageToDatabase() throws IOException, InterruptedException, SQLException {
  JDBCLogHandler logHandler=new JDBCLogHandler(HELLO_HANDLER,DefaultServer.getWorker(),"common",ds);
  CompletionLatchHandler latchHandler;
  DefaultServer.setRootHandler(latchHandler=new CompletionLatchHandler(logHandler));
  TestHttpClient client=new TestHttpClient();
  try {
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
    HttpResponse result=client.execute(get);
    latchHandler.await();
    logHandler.awaitWrittenForTest();
    Assert.assertEquals(200,result.getStatusLine().getStatusCode());
    Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
  }
  finally {
    Connection conn=null;
    Statement statement=null;
    try {
      conn=ds.getConnection();
      statement=conn.createStatement();
      ResultSet resultDatabase=statement.executeQuery("SELECT * FROM PUBLIC.ACCESS;");
      resultDatabase.next();
      Assert.assertEquals("127.0.0.1",resultDatabase.getString(logHandler.getRemoteHostField()));
      Assert.assertEquals("5",resultDatabase.getString(logHandler.getBytesField()));
      Assert.assertEquals("200",resultDatabase.getString(logHandler.getStatusField()));
      client.getConnectionManager().shutdown();
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
}
