@Test public void primLongValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("primLongParam").invoke(mockController,context);
  verify(mockController).primLongParam(0L);
  assertTrue(validation.hasFieldViolation("param1"));
}
