@Test public void validationShouldFailWhenBadRequest(){
  create("required").invoke(mockController,context);
  verify(mockController).required(null);
  assertTrue(validation.hasFieldViolation("param1"));
}
