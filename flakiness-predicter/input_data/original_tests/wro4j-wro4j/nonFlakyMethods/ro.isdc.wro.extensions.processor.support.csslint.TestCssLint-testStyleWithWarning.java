@Test(expected=CssLintException.class) public void testStyleWithWarning() throws Exception {
  cssLint.setOptions("box-model");
  cssLint.validate(".foo { width: 100px; padding: 10px; }");
}
