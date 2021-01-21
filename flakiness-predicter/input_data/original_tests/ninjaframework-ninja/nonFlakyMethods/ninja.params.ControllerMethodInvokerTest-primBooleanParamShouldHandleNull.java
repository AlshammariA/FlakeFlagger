@Test public void primBooleanParamShouldHandleNull() throws Exception {
  create("primBooleanParam").invoke(mockController,context);
  verify(mockController).primBooleanParam(false);
  assertFalse(validation.hasViolations());
}
