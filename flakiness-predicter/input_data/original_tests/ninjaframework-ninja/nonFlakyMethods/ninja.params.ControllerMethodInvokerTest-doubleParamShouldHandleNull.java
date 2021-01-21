@Test public void doubleParamShouldHandleNull() throws Exception {
  create("doubleParam").invoke(mockController,context);
  verify(mockController).doubleParam(null);
  assertFalse(validation.hasViolations());
}
