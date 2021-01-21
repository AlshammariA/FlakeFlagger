@Test public void intParamShouldBeParsedToInteger() throws Exception {
  when(context.getParameter("param1")).thenReturn("20");
  create("intParam").invoke(mockController,context);
  verify(mockController).intParam(20);
}
