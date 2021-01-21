@Test(expected=CssLintException.class) public void testRegexSelectors() throws Exception {
  cssLint.setOptions("regex-selectors");
  cssLint.validate("li[class*=foo]{ color: red; }");
}
