@Test public void doubleParamShouldBeParsedToDouble() throws Exception {
  when(context.getParameter("param1")).thenReturn("3.14");
  create("doubleParam").invoke(mockController,context);
  verify(mockController).doubleParam(3.14);
}
