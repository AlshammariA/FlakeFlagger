@Test public void primFloatParamShouldHandleNull() throws Exception {
  create("primFloatParam").invoke(mockController,context);
  verify(mockController).primFloatParam(0);
  assertFalse(validation.hasViolations());
}
