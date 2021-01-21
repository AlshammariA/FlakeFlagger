@Test public void primLongParamShouldBeParsedToLong() throws Exception {
  when(context.getParameter("param1")).thenReturn("20");
  create("primLongParam").invoke(mockController,context);
  verify(mockController).primLongParam(20);
}
