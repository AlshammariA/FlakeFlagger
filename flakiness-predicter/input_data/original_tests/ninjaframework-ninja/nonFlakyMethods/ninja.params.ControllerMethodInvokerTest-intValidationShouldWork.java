@Test public void intValidationShouldWork() throws Exception {
  when(context.getParameter("param1")).thenReturn("blah");
  create("intParam").invoke(mockController,context);
  verify(mockController).intParam(0);
  assertTrue(validation.hasFieldViolation("param1"));
}
