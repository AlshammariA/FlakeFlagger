/** 
 * Test a url css resource.
 */
@Test public void processUrlResourceType() throws IOException {
  WroTestUtils.compareProcessedResourceContents("classpath:" + CSS_INPUT_NAME,"classpath:cssUrlRewriting-url-outcome.css",new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
      processor.process(createMockResource("http://www.site.com/static/css/" + CSS_INPUT_NAME),reader,writer);
    }
  }
);
}
