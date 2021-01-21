@Test public void shouldComputeEligibilityForMinimizeAwareProcessorWithCssType(){
  assertTrue(new ProcessorDecorator(new CssMinProcessor()).isEligible(true,ResourceType.CSS));
  assertFalse(new ProcessorDecorator(new CssMinProcessor()).isEligible(false,ResourceType.CSS));
  assertFalse(new ProcessorDecorator(new CssMinProcessor()).isEligible(true,ResourceType.JS));
  assertFalse(new ProcessorDecorator(new CssMinProcessor()).isEligible(false,ResourceType.JS));
}
