@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new Less4jProcessor(),ResourceType.CSS);
}
