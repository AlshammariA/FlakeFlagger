@Test public void primFloatParamShouldBeParsedToFloat() throws Exception {
  when(context.getParameter("param1")).thenReturn("3.14");
  create("primFloatParam").invoke(mockController,context);
  verify(mockController).primFloatParam(3.14f);
}
