@Test public void primDoubleParamShouldHandleNull() throws Exception {
  create("primDoubleParam").invoke(mockController,context);
  verify(mockController).primDoubleParam(0);
  assertFalse(validation.hasViolations());
}
