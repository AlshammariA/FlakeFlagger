@Test public void shouldValidateWithMultipleOptions() throws Exception {
  jsLint.setOptions("undef,eqeqeq");
  jsLint.validate("");
}
