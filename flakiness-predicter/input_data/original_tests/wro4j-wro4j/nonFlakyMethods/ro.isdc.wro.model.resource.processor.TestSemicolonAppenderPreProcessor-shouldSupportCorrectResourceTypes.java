@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new SemicolonAppenderPreProcessor(),ResourceType.JS);
}
