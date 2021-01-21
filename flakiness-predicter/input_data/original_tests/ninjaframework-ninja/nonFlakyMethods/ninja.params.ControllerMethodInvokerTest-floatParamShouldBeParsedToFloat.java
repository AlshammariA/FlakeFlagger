@Test public void floatParamShouldBeParsedToFloat() throws Exception {
  when(context.getParameter("param1")).thenReturn("3.14");
  create("floatParam").invoke(mockController,context);
  verify(mockController).floatParam(3.14f);
}
