@Override @Test public void shouldSupportOnlyCssResources(){
  WroTestUtils.assertProcessorSupportResourceTypes(processor,ResourceType.CSS);
}
