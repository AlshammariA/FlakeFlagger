@Test public void validationWithNullObject(){
  validateJSR303(null);
  assertFalse(context.getValidation().hasViolations());
  validateJSR303WithRequired(null);
  assertTrue(context.getValidation().hasViolations());
}
