@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new JsHintProcessor(),ResourceType.JS);
}
