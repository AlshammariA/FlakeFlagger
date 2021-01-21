@Test public void shouldComputeCorrectlySupportedResourceTypes(){
  assertTrue(Arrays.equals(new ResourceType[]{ResourceType.JS},new ProcessorDecorator(new JSMinProcessor()).getSupportedResourceTypes()));
  assertTrue(Arrays.equals(new ResourceType[]{ResourceType.CSS},new ProcessorDecorator(new CssMinProcessor()).getSupportedResourceTypes()));
  assertTrue(Arrays.equals(ResourceType.values(),new ProcessorDecorator(new CommentStripperProcessor()).getSupportedResourceTypes()));
}
