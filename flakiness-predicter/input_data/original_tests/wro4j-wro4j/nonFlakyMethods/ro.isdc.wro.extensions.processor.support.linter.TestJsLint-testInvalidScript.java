@Test(expected=LinterException.class) public void testInvalidScript() throws Exception {
  jsLint.validate("al ert(1)");
}
