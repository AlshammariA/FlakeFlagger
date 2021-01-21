@Test public void paramAnnotatedArgumentShouldBePassed() throws Exception {
  when(context.getParameter("param1")).thenReturn("value");
  create("param").invoke(mockController,context);
  verify(mockController).param("value");
}
