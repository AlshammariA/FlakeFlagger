@Test(expected=LinterException.class) public void shouldValidateWithUndefOption() throws Exception {
  jsHint.setOptions("undef");
  jsHint.validate("$(function(){})(jQuery);");
}
