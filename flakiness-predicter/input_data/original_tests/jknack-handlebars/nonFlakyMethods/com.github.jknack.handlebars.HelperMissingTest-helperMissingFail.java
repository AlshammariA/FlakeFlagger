/** 
 * Handlebars syntax, it MUST fail.
 * @throws IOException
 */
@Test(expected=HandlebarsException.class) public void helperMissingFail() throws IOException {
  shouldCompileTo("{{missing x}}",new Object(),"must fail");
}
