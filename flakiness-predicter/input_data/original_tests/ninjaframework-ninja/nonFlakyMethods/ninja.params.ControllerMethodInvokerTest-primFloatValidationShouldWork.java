@Test public void primFloatValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("primFloatParam").invoke(mockController,context);
  verify(mockController).primFloatParam(0);
  assertTrue(validation.hasFieldViolation("param1"));
}
