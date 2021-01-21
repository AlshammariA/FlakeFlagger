@Test public void primDoubleValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("primDoubleParam").invoke(mockController,context);
  verify(mockController).primDoubleParam(0);
  assertTrue(validation.hasFieldViolation("param1"));
}
