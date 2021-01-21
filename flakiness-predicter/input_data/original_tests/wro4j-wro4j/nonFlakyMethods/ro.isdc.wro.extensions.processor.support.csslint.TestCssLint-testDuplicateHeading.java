@Test(expected=CssLintException.class) public void testDuplicateHeading() throws Exception {
  cssLint.setOptions("unique-headings");
  cssLint.validate("h1 { color: red;} h1 {color: blue;}");
}
