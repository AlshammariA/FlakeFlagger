@Test public void testRunManyClients() throws Exception {
  executor.execute(runner);
  int count=10;
  while (count-- > 0) {
    MockClient client=new MockClient();
    listener.addClient(client);
    int retries=DELAY / SHORT_DELAY;
synchronized (client) {
      while (retries-- > 0 && !client.isRunning()) {
        client.wait(SHORT_DELAY);
      }
    }
    assertTrue(runner.awaitRunState(true,DELAY));
  }
  runner.stop();
}
