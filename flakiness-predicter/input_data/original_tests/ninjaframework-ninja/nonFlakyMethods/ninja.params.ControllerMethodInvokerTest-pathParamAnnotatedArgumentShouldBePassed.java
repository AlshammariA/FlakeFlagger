@Test public void pathParamAnnotatedArgumentShouldBePassed() throws Exception {
  when(context.getPathParameter("param1")).thenReturn("value");
  create("pathParam").invoke(mockController,context);
  verify(mockController).pathParam("value");
}
