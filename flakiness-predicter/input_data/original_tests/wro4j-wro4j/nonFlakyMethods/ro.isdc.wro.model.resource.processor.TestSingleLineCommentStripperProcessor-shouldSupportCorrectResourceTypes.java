@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new SingleLineCommentStripperProcessor(),ResourceType.CSS,ResourceType.JS);
}
