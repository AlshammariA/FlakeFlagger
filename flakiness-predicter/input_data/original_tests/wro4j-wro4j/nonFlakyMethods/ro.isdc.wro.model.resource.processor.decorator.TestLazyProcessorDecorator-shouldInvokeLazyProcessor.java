@Test public void shouldInvokeLazyProcessor() throws Exception {
  final ResourceType expectedResourceType=ResourceType.CSS;
  when(mockProcessorDecorator.isMinimize()).thenReturn(true);
  when(mockProcessorDecorator.getSupportedResourceType()).thenReturn(new SupportedResourceType(){
    public Class<? extends Annotation> annotationType(){
      return SupportedResourceType.class;
    }
    public ResourceType value(){
      return expectedResourceType;
    }
  }
);
  when(mockProcessorDecorator.isSupported()).thenReturn(false);
  victim=new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>(){
    @Override protected ResourcePreProcessor initialize(){
      return mockProcessorDecorator;
    }
  }
);
  WroTestUtils.createInjector().inject(victim);
  victim.process(null,new StringReader(""),new StringWriter());
  assertTrue(victim.isMinimize());
  assertFalse(victim.isSupported());
  assertEquals(expectedResourceType,victim.getSupportedResourceType().value());
  verify(mockProcessorDecorator).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
