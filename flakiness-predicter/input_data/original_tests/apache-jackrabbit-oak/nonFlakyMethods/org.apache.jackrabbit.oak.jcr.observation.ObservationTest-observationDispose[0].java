@Test public void observationDispose() throws RepositoryException, InterruptedException, ExecutionException, TimeoutException {
  final ExpectationListener listener=new ExpectationListener();
  Expectation hasEvents=listener.expect(new Expectation("has events after registering"));
  final Expectation noEvents=listener.expect(new Expectation("has no more events after unregistering",false));
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable(){
    private int c;
    @Override public void run(){
      try {
        getNode(TEST_PATH).addNode("c" + c++).getSession().save();
      }
 catch (      RepositoryException e) {
        throw new RuntimeException(e);
      }
    }
  }
,10,10,TimeUnit.MILLISECONDS);
  assertNotNull(hasEvents.get(TIME_OUT,TimeUnit.SECONDS));
  Executors.newSingleThreadExecutor().submit(new Callable<Void>(){
    @Override public Void call() throws Exception {
      observationManager.removeEventListener(listener);
      noEvents.enable(true);
      return null;
    }
  }
).get(10,TimeUnit.SECONDS);
  assertFalse(noEvents.wait(4,TimeUnit.SECONDS));
}
