/** 
 * Mustache fallback.
 * @throws IOException
 */
@Test public void helperMissingOk() throws IOException {
  shouldCompileTo("{{missing}}",new Object(),"");
}
