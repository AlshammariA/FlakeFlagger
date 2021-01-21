@Test public void booleanParamShouldBeParsedToBoolean() throws Exception {
  when(context.getParameter("param1")).thenReturn("true");
  create("booleanParam").invoke(mockController,context);
  verify(mockController).booleanParam(true);
}
