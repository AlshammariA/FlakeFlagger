@Test public void integerParamShouldBeParsedToInteger() throws Exception {
  when(context.getParameter("param1")).thenReturn("20");
  create("integerParam").invoke(mockController,context);
  verify(mockController).integerParam(20);
}
