@Test public void floatValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("floatParam").invoke(mockController,context);
  verify(mockController).floatParam(null);
  assertTrue(validation.hasFieldViolation("param1"));
}
