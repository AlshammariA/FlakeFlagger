@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new PlaceholderProcessor(),ResourceType.CSS,ResourceType.JS);
}
