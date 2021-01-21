@Test public void shouldApplyProcessor() throws Exception {
  final String processedMessage="DONE";
  final List<ResourcePreProcessor> processors=new ArrayList<ResourcePreProcessor>();
  processors.add(new ResourcePreProcessor(){
    public void process(    final Resource resource,    final Reader reader,    final Writer writer) throws IOException {
      writer.write(processedMessage);
    }
  }
);
  doFilterWithProcessors(processors);
  Assert.assertEquals(processedMessage,new String(outputStream.toByteArray()));
}
