@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new LessCssProcessor(),ResourceType.CSS);
}
