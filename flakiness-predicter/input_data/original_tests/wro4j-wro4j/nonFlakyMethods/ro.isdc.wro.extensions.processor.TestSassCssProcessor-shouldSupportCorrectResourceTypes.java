@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new SassCssProcessor(),ResourceType.CSS);
}
