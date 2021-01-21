@Test public void shouldBeThreadSafe() throws Exception {
  registry=new LifecycleCallbackRegistry(){
    @Override protected void onException(    final Exception e){
      throw WroRuntimeException.wrap(e);
    }
  }
;
  registry.registerCallback(new ObjectFactory<LifecycleCallback>(){
    public LifecycleCallback create(){
      return new PerformanceLoggerCallback();
    }
  }
);
  WroTestUtils.runConcurrently(new Callable<Void>(){
    public Void call() throws Exception {
      Context.set(Context.standaloneContext());
      try {
        registry.onBeforeModelCreated();
        Thread.sleep(10);
        registry.onAfterModelCreated();
        registry.onBeforeMerge();
        registry.onBeforePreProcess();
        registry.onAfterPreProcess();
        registry.onAfterMerge();
        registry.onBeforePostProcess();
        registry.onAfterPostProcess();
        registry.onProcessingComplete();
        return null;
      }
  finally {
        Context.unset();
      }
    }
  }
);
}
