@Test(expected=CssLintException.class) public void testStyleContainingAScript() throws Exception {
  cssLint.validate("$(function(){})(jQuery);");
}
