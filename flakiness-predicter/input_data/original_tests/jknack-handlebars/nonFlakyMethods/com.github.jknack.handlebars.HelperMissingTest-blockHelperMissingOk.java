/** 
 * Mustache fallback.
 * @throws IOException
 */
@Test public void blockHelperMissingOk() throws IOException {
  shouldCompileTo("{{#missing}}This is a mustache fallback{{/missing}}",new Object(),"");
}
