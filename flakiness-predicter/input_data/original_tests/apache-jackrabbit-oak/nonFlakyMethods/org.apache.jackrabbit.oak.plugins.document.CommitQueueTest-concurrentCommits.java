@Test public void concurrentCommits() throws Exception {
  final DocumentNodeStore store=new DocumentMK.Builder().getNodeStore();
  AtomicBoolean running=new AtomicBoolean(true);
  final List<Exception> exceptions=Collections.synchronizedList(new ArrayList<Exception>());
  Closeable observer=store.addObserver(new Observer(){
    private Revision before=new Revision(0,0,store.getClusterId());
    @Override public void contentChanged(    @Nonnull NodeState root,    @Nullable CommitInfo info){
      DocumentNodeState after=(DocumentNodeState)root;
      Revision r=after.getRevision();
      System.out.println("seen: " + r);
      if (r.compareRevisionTime(before) < 0) {
        exceptions.add(new Exception("Inconsistent revision sequence. Before: " + before + ", after: "+ r));
      }
      before=r;
    }
  }
);
  List<Thread> writers=new ArrayList<Thread>();
  for (int i=0; i < NUM_WRITERS; i++) {
    final Random random=new Random(i);
    writers.add(new Thread(new Runnable(){
      @Override public void run(){
        try {
          for (int i=0; i < COMMITS_PER_WRITER; i++) {
            Commit commit=store.newCommit(null);
            try {
              Thread.sleep(0,random.nextInt(1000));
            }
 catch (            InterruptedException e) {
            }
            if (random.nextInt(5) == 0) {
              store.canceled(commit);
            }
 else {
              boolean isBranch=random.nextInt(5) == 0;
              store.done(commit,isBranch,null);
            }
          }
        }
 catch (        Exception e) {
          exceptions.add(e);
        }
      }
    }
));
  }
  for (  Thread t : writers) {
    t.start();
  }
  for (  Thread t : writers) {
    t.join();
  }
  running.set(false);
  observer.close();
  store.dispose();
  for (  Exception e : exceptions) {
    throw e;
  }
}
