/** 
 * When background url contains a dataUri, the rewriting should have no effect.
 */
@Test public void processResourceWithDataUriEncodedValue() throws IOException {
  final String resourceUri="classpath:cssUrlRewriting-dataUri.css";
  WroTestUtils.compareProcessedResourceContents(resourceUri,resourceUri,new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
      processor.process(createMockResource(resourceUri),reader,writer);
    }
  }
);
}
