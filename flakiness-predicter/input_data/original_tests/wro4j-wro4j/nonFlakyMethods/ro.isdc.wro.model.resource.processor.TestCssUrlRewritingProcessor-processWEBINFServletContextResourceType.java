/** 
 * Test a resource which is located inside WEB-INF protected folder.
 */
@Test public void processWEBINFServletContextResourceType() throws IOException {
  WroTestUtils.compareProcessedResourceContents("classpath:" + CSS_INPUT_NAME,"classpath:cssUrlRewriting-WEBINFservletContext-outcome.css",new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
      processor.process(createMockResource("/WEB-INF/" + CSS_INPUT_NAME),reader,writer);
    }
  }
);
}
