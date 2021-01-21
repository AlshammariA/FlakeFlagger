@Test public void booleanParamShouldHandleNull() throws Exception {
  create("booleanParam").invoke(mockController,context);
  verify(mockController).booleanParam(null);
  assertFalse(validation.hasViolations());
}
