@Test(expected=LinterException.class) public void testWithUndefOption() throws Exception {
  jsLint.setOptions("undef");
  jsLint.validate("$(function(){})(jQuery);");
}
