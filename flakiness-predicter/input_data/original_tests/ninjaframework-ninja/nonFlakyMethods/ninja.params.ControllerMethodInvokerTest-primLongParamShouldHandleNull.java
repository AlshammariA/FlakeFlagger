@Test public void primLongParamShouldHandleNull() throws Exception {
  create("primLongParam").invoke(mockController,context);
  verify(mockController).primLongParam(0);
  assertFalse(validation.hasViolations());
}
