@Test public void shouldValidateWithMultipleOptions() throws Exception {
  jsHint.setOptions("indent","eqeqeq");
  jsHint.validate(VALID_JS);
}
