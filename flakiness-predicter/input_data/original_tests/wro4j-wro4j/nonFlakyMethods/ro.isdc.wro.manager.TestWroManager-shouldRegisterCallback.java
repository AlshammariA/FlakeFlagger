@Test public void shouldRegisterCallback(){
  final LifecycleCallback mockCallback=Mockito.mock(LifecycleCallback.class);
  victim.registerCallback(new ObjectFactory<LifecycleCallback>(){
    public LifecycleCallback create(){
      return mockCallback;
    }
  }
);
  victim.getCallbackRegistry().onProcessingComplete();
  Mockito.verify(mockCallback,Mockito.atLeastOnce()).onProcessingComplete();
}
