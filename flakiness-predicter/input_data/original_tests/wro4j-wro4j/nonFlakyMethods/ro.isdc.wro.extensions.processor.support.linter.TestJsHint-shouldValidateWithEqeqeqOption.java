@Test(expected=LinterException.class) public void shouldValidateWithEqeqeqOption() throws Exception {
  jsHint.setOptions("eqeqeq");
  jsHint.validate("var j = 1;var i = j == 0 ? j + 1 : j - 1;");
}
