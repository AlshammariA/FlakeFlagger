@Test public void testConnect() throws Exception {
  Future<Socket> connectorTask=executor.submit(connector);
  Socket socket=connectorTask.get(2 * DELAY,TimeUnit.MILLISECONDS);
  assertNotNull(socket);
  connectorTask.cancel(true);
  assertTrue(connectorTask.isDone());
  socket.close();
}
