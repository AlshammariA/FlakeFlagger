@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new JawrCssMinifierProcessor(),ResourceType.CSS);
}
