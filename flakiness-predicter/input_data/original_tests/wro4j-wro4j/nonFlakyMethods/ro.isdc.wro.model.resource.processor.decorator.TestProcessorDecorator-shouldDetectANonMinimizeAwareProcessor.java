@Test public void shouldDetectANonMinimizeAwareProcessor(){
  assertFalse(new ProcessorDecorator(new SemicolonAppenderPreProcessor()).isMinimize());
}
