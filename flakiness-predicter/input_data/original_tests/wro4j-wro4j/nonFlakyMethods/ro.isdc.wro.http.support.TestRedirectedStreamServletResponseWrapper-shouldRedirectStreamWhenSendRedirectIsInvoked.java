/** 
 * instruct vitim to use custom external resource locator (to return expected message).
 */
@Test public void shouldRedirectStreamWhenSendRedirectIsInvoked() throws Exception {
  final String message="Hello world!";
  victim=new RedirectedStreamServletResponseWrapper(redirectedStream,mockResponse){
    @Override protected UriLocator newExternalResourceLocator(){
      return new ClasspathUriLocator(){
        @Override public InputStream locate(        final String uri) throws IOException {
          return new ByteArrayInputStream(message.getBytes());
        }
      }
;
    }
  }
;
  victim.sendRedirect("/does/not/matter");
  Assert.assertEquals(message,new String(redirectedStream.toByteArray()));
}
