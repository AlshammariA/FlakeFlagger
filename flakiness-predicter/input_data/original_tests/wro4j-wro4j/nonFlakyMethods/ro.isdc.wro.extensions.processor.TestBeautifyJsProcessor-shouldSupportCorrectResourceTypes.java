@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new BeautifyJsProcessor(),ResourceType.JS);
}
