@Test public void sessionShouldBePassed() throws Exception {
  create("session").invoke(mockController,context);
  verify(mockController).session(session);
}
