@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new CoffeeScriptProcessor(),ResourceType.JS);
}
