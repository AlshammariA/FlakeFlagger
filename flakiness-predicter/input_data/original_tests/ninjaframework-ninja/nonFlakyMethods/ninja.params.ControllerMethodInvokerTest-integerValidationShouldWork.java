@Test public void integerValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("integerParam").invoke(mockController,context);
  verify(mockController).integerParam(null);
  assertTrue(validation.hasFieldViolation("param1"));
}
