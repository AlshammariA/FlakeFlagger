@Test public void shouldComputeEligibilityForProcessorWithJsType(){
  assertTrue(new ProcessorDecorator(new SemicolonAppenderPreProcessor()).isEligible(true,ResourceType.JS));
  assertTrue(new ProcessorDecorator(new SemicolonAppenderPreProcessor()).isEligible(false,ResourceType.JS));
  assertFalse(new ProcessorDecorator(new SemicolonAppenderPreProcessor()).isEligible(true,ResourceType.CSS));
  assertFalse(new ProcessorDecorator(new SemicolonAppenderPreProcessor()).isEligible(false,ResourceType.CSS));
}
