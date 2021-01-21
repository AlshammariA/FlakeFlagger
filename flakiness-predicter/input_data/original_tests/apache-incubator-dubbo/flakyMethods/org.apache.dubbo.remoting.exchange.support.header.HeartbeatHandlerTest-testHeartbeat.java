@Test public void testHeartbeat() throws Exception {
  URL serverURL=URL.valueOf("header://localhost:55555?transporter=netty3");
  serverURL=serverURL.addParameter(Constants.HEARTBEAT_KEY,1000);
  TestHeartbeatHandler handler=new TestHeartbeatHandler();
  server=Exchangers.bind(serverURL,handler);
  System.out.println("Server bind successfully");
  client=Exchangers.connect(serverURL);
  Thread.sleep(10000);
  System.err.println("++++++++++++++ disconnect count " + handler.disconnectCount);
  System.err.println("++++++++++++++ connect count " + handler.connectCount);
  Assert.assertTrue(handler.disconnectCount == 0);
  Assert.assertTrue(handler.connectCount == 1);
}
