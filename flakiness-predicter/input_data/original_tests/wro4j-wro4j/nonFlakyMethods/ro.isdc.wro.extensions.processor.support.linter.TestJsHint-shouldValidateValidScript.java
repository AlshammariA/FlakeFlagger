@Test public void shouldValidateValidScript() throws Exception {
  jsHint.validate("$(function(){})(jQuery);");
}
