@Test public void doubleValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("doubleParam").invoke(mockController,context);
  verify(mockController).doubleParam(null);
  assertTrue(validation.hasFieldViolation("param1"));
}
