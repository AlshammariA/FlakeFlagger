@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new GoogleClosureCompressorProcessor(),ResourceType.JS);
}
