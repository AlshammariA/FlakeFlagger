@Test public void shouldComputeEligibilityForProcessorWithCssType(){
  assertTrue(new ProcessorDecorator(new CssVariablesProcessor()).isEligible(true,ResourceType.CSS));
  assertTrue(new ProcessorDecorator(new CssVariablesProcessor()).isEligible(false,ResourceType.CSS));
  assertFalse(new ProcessorDecorator(new CssVariablesProcessor()).isEligible(true,ResourceType.JS));
  assertFalse(new ProcessorDecorator(new CssVariablesProcessor()).isEligible(false,ResourceType.JS));
}
