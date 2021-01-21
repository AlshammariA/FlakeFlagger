@Test public void shouldComputeEligibilityForMinimizeAwareProcessorWithJsType(){
  assertTrue(new ProcessorDecorator(new JSMinProcessor()).isEligible(true,ResourceType.JS));
  assertFalse(new ProcessorDecorator(new JSMinProcessor()).isEligible(true,ResourceType.CSS));
  assertFalse(new ProcessorDecorator(new JSMinProcessor()).isEligible(false,ResourceType.JS));
  assertFalse(new ProcessorDecorator(new JSMinProcessor()).isEligible(false,ResourceType.CSS));
}
