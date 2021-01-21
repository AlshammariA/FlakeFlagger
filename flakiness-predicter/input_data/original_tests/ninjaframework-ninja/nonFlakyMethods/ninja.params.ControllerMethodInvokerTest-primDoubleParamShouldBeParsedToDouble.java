@Test public void primDoubleParamShouldBeParsedToDouble() throws Exception {
  when(context.getParameter("param1")).thenReturn("3.14");
  create("primDoubleParam").invoke(mockController,context);
  verify(mockController).primDoubleParam(3.14);
}
