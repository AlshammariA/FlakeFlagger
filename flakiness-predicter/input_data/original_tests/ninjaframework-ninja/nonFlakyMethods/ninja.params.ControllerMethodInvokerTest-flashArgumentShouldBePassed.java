@Test public void flashArgumentShouldBePassed() throws Exception {
  create("flash").invoke(mockController,context);
  verify(mockController).flash(flash);
}
