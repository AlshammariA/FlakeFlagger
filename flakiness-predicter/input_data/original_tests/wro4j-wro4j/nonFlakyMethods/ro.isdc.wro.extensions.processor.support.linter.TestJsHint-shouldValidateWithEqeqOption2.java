@Test(expected=LinterException.class) public void shouldValidateWithEqeqOption2() throws Exception {
  jsHint.setOptions("eqeqeq");
  jsHint.validate("if (text == 0) {win.location.href = link; }");
}
