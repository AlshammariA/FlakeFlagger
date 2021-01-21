@Test public void longParamShouldBeParsedToLong() throws Exception {
  when(context.getParameter("param1")).thenReturn("20");
  create("longParam").invoke(mockController,context);
  verify(mockController).longParam(20l);
}
