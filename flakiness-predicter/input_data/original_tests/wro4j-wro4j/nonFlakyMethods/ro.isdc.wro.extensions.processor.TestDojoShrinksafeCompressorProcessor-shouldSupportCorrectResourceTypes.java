@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new DojoShrinksafeCompressorProcessor(),ResourceType.JS);
}
