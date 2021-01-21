/** 
 * Test a servletContext css resource.
 */
@Test public void processServletContextResourceTypeWithAggregatedFolderSet() throws IOException {
  Context.get().setAggregatedFolderPath("wro/css");
  WroTestUtils.compareProcessedResourceContents("classpath:" + CSS_INPUT_NAME,"classpath:cssUrlRewriting-servletContext-aggregatedFolderSet-outcome.css",new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
      processor.process(createMockResource("/static/img/" + CSS_INPUT_NAME),reader,writer);
    }
  }
);
}
