@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new CssCompressorProcessor(),ResourceType.CSS);
}
