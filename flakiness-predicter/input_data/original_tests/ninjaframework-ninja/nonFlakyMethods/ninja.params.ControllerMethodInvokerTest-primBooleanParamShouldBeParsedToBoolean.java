@Test public void primBooleanParamShouldBeParsedToBoolean() throws Exception {
  when(context.getParameter("param1")).thenReturn("true");
  create("primBooleanParam").invoke(mockController,context);
  verify(mockController).primBooleanParam(true);
}
