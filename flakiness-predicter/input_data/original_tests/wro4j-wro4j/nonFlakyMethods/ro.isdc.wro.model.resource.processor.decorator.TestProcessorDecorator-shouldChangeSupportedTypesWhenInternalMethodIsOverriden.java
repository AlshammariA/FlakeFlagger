@Test public void shouldChangeSupportedTypesWhenInternalMethodIsOverriden(){
  final ResourcePreProcessor processor=new ProcessorDecorator(new JSMinProcessor()){
    @Override protected SupportedResourceType getSupportedResourceTypeInternal(){
      return null;
    }
  }
;
  assertNull(null,new ProcessorDecorator(processor).getSupportedResourceType());
}
