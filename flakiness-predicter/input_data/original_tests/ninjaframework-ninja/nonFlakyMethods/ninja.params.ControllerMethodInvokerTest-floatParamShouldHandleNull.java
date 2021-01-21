@Test public void floatParamShouldHandleNull() throws Exception {
  create("floatParam").invoke(mockController,context);
  verify(mockController).floatParam(null);
  assertFalse(validation.hasViolations());
}
