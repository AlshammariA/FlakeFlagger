@Test public void contextShouldBePassed() throws Exception {
  create("context").invoke(mockController,context);
  verify(mockController).context(context);
}
