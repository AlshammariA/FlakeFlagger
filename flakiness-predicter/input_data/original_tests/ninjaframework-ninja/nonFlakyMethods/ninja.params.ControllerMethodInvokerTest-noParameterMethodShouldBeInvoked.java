@Test public void noParameterMethodShouldBeInvoked() throws Exception {
  create("noParameter").invoke(mockController,context);
  verify(mockController).noParameter();
}
