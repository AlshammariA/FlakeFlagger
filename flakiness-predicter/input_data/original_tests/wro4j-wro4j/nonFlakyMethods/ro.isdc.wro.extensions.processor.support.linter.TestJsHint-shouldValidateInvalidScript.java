@Test(expected=LinterException.class) public void shouldValidateInvalidScript() throws Exception {
  jsHint.validate("al ert(1)");
}
