@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new JsonHPackProcessor(true),ResourceType.JS);
}
