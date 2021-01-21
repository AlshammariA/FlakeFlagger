@Test public void observerGarbageCollection() throws ExecutionException, InterruptedException {
  OrbitStage stage1=createStage();
  SomeChatObserver observer1=new SomeChatObserver();
  final ISomeChatObserver ref1=stage1.getObserverReference(observer1);
  ref1.receiveMessage(null,"hello").join();
  observer1=null;
  System.gc();
  expectException(() -> ref1.receiveMessage(null,"hello").join());
}
