@Test public void validationShouldPassWhenGoodRequest(){
  when(context.getParameter("param1")).thenReturn("value");
  create("required").invoke(mockController,context);
  verify(mockController).required("value");
  assertFalse(validation.hasViolations());
}
