/** 
 * Test a classpath css resource.
 */
@Test public void processClasspathResourceType() throws IOException {
  final String resourceUri="classpath:" + CSS_INPUT_NAME;
  WroTestUtils.compareProcessedResourceContents(resourceUri,"classpath:cssUrlRewriting-classpath-outcome.css",new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
      processor.process(createMockResource(resourceUri),reader,writer);
    }
  }
);
}
