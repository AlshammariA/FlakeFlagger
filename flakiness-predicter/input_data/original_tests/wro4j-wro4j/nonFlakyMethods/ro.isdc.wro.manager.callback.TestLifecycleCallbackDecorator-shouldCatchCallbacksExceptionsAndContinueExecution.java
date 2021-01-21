@Test public void shouldCatchCallbacksExceptionsAndContinueExecution(){
  final LifecycleCallback callback=Mockito.spy(new PerformanceLoggerCallback());
  decorator=new LifecycleCallbackDecorator(callback);
  final LifecycleCallbackRegistry registry=new LifecycleCallbackRegistry();
  registry.registerCallback(new ObjectFactory<LifecycleCallback>(){
    public LifecycleCallback create(){
      return decorator;
    }
  }
);
  registry.onBeforeModelCreated();
  registry.onAfterModelCreated();
  registry.onBeforePreProcess();
  registry.onAfterPreProcess();
  registry.onBeforePostProcess();
  registry.onAfterPostProcess();
  registry.onBeforeMerge();
  registry.onAfterMerge();
  registry.onProcessingComplete();
  Mockito.verify(callback).onBeforeModelCreated();
  Mockito.verify(callback).onAfterModelCreated();
  Mockito.verify(callback).onBeforePreProcess();
  Mockito.verify(callback).onAfterPreProcess();
  Mockito.verify(callback).onBeforePostProcess();
  Mockito.verify(callback).onAfterPostProcess();
  Mockito.verify(callback).onBeforeMerge();
  Mockito.verify(callback).onAfterMerge();
  Mockito.verify(callback).onProcessingComplete();
}
