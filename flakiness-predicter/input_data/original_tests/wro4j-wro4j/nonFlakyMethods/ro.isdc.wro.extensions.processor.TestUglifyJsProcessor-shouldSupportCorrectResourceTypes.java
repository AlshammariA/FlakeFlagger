@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new UglifyJsProcessor(),ResourceType.JS);
}
