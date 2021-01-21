@Test public void testRunClientAndVisit() throws Exception {
  executor.execute(runner);
  MockClient client=new MockClient();
  listener.addClient(client);
  int retries=DELAY / SHORT_DELAY;
synchronized (client) {
    while (retries-- > 0 && !client.isRunning()) {
      client.wait(SHORT_DELAY);
    }
  }
  assertTrue(runner.awaitRunState(true,DELAY));
  MockClientVisitor visitor=new MockClientVisitor();
  runner.accept(visitor);
  assertSame(client,visitor.getLastVisited());
  runner.stop();
}
