/** 
 * Test a servletContext css resource.
 */
@Test public void processServletContextResourceType() throws IOException {
  WroTestUtils.compareProcessedResourceContents("classpath:" + CSS_INPUT_NAME,"classpath:cssUrlRewriting-servletContext-outcome.css",new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
      processor.process(createMockResource("/static/img/" + CSS_INPUT_NAME),reader,writer);
    }
  }
);
}
