@Test public void longValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("longParam").invoke(mockController,context);
  verify(mockController).longParam(null);
  assertTrue(validation.hasFieldViolation("param1"));
}
