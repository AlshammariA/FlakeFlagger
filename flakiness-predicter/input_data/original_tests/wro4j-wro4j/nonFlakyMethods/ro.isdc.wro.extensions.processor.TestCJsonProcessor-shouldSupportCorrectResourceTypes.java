@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new CJsonProcessor(true),ResourceType.JS);
}
