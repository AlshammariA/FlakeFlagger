@Test public void shouldChangeMinimizaFlagWhenInternalMethodIsOverriden(){
  final ResourcePreProcessor processor=new ProcessorDecorator(new JSMinProcessor()){
    @Override protected boolean isMinimizeInternal(){
      return false;
    }
  }
;
  assertFalse(new ProcessorDecorator(processor).isMinimize());
}
