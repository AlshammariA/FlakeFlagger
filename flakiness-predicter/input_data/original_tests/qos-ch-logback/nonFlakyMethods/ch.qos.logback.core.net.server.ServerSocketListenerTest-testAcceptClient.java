@Test public void testAcceptClient() throws Exception {
  RunnableClient localClient=new RunnableClient(InetAddress.getLocalHost(),serverSocket.getLocalPort());
  Thread thread=new Thread(localClient);
  thread.start();
synchronized (localClient) {
    int retries=200;
    while (retries-- > 0 && !localClient.isConnected()) {
      localClient.wait(10);
    }
  }
  assertTrue(localClient.isConnected());
  localClient.close();
  serverSocket.setSoTimeout(5000);
  Client client=listener.acceptClient();
  assertNotNull(client);
  client.close();
}
