@Test public void shouldSupportCorrectResourceTypes(){
  WroTestUtils.assertProcessorSupportResourceTypes(new MultiLineCommentStripperProcessor(),ResourceType.CSS,ResourceType.JS);
}
