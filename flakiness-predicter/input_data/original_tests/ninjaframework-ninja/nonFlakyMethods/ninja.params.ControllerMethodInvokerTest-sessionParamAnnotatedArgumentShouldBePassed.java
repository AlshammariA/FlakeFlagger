@Test public void sessionParamAnnotatedArgumentShouldBePassed() throws Exception {
  when(session.get("param1")).thenReturn("value");
  create("sessionParam").invoke(mockController,context);
  verify(mockController).sessionParam("value");
}
