@Test(expected=LinterException.class) public void testValidScript() throws Exception {
  jsLint.validate("$(function(){})(jQuery);");
}
