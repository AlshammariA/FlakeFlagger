@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new CssMinProcessor(),ResourceType.CSS);
}
