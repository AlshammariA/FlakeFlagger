@Test public void putTokenImpl() throws InterruptedException, ExecutionException {
  final Set<PutToken> tokens=Collections.synchronizedSet(new HashSet<PutToken>());
  Set<Future<?>> results=new HashSet<Future<?>>();
  ExecutorService executorService=Executors.newFixedThreadPool(100);
  for (int i=0; i < 100; i++) {
    results.add(executorService.submit(new Callable<Void>(){
      @Override public Void call() throws Exception {
        for (int j=0; j < 10000; j++) {
          assertTrue(tokens.add(new PutTokenImpl()));
        }
        return null;
      }
    }
));
  }
  for (  Future<?> result : results) {
    result.get();
  }
}
