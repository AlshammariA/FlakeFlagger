@Test(expected=CssLintException.class) public void testOperaGradient() throws Exception {
  cssLint.setOptions("gradients");
  cssLint.validate(".foo { background: -o-linear-gradient(top, #1e5799 , #2989d8 , #207cca , #7db9e8 ); }");
}
