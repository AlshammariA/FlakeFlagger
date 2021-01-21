@Test public void integerParamShouldHandleNull() throws Exception {
  create("integerParam").invoke(mockController,context);
  verify(mockController).integerParam(null);
  assertFalse(validation.hasViolations());
}
