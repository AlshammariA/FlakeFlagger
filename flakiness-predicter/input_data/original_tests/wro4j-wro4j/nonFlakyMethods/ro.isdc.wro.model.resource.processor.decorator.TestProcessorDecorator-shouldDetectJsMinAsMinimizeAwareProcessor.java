@Test public void shouldDetectJsMinAsMinimizeAwareProcessor(){
  assertTrue(new ProcessorDecorator(new JSMinProcessor()).isMinimize());
}
