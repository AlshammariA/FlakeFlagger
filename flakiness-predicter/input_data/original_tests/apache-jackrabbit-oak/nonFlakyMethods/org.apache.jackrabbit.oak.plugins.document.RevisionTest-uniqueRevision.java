@Test public void uniqueRevision() throws Exception {
  final BlockingQueue<Revision> revisionQueue=Queues.newLinkedBlockingQueue();
  int noOfThreads=60;
  final int noOfLoops=1000;
  List<Thread> workers=new ArrayList<Thread>();
  final AtomicBoolean stop=new AtomicBoolean();
  final CountDownLatch startLatch=new CountDownLatch(1);
  final CountDownLatch stopLatch=new CountDownLatch(noOfThreads);
  for (int i=0; i < noOfThreads; i++) {
    workers.add(new Thread(new Runnable(){
      @Override public void run(){
        Uninterruptibles.awaitUninterruptibly(startLatch);
        for (int j=0; j < noOfLoops && !stop.get(); j++) {
          revisionQueue.add(Revision.newRevision(1));
        }
        stopLatch.countDown();
      }
    }
));
  }
  final List<Revision> duplicates=Lists.newArrayList();
  final Set<Revision> seenRevs=Sets.newHashSet();
  workers.add(new Thread(new Runnable(){
    @Override public void run(){
      startLatch.countDown();
      while (!stop.get()) {
        List<Revision> revs=Lists.newArrayList();
        Queues.drainUninterruptibly(revisionQueue,revs,5,100,TimeUnit.MILLISECONDS);
        record(revs);
      }
      List<Revision> revs=Lists.newArrayList();
      revisionQueue.drainTo(revs);
      record(revs);
    }
    private void record(    List<Revision> revs){
      for (      Revision rev : revs) {
        if (!seenRevs.add(rev)) {
          duplicates.add(rev);
        }
      }
      if (!duplicates.isEmpty()) {
        stop.set(true);
      }
    }
  }
));
  for (  Thread t : workers) {
    t.start();
  }
  stopLatch.await();
  stop.set(true);
  for (  Thread t : workers) {
    t.join();
  }
  assertTrue(String.format("Duplicate rev seen %s %n Seen %s",duplicates,seenRevs),duplicates.isEmpty());
}
