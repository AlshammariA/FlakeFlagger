@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(processor,ResourceType.CSS,ResourceType.JS);
}
