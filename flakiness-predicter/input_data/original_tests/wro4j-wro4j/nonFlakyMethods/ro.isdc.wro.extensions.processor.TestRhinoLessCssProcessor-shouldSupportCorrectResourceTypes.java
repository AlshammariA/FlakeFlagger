@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new RhinoLessCssProcessor(),ResourceType.CSS);
}
