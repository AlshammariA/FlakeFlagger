@Test public void intParamShouldHandleNull() throws Exception {
  create("intParam").invoke(mockController,context);
  verify(mockController).intParam(0);
  assertFalse(validation.hasViolations());
}
