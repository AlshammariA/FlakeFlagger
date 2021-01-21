@Test public void uniqueRevision2() throws Exception {
  List<Thread> threads=new ArrayList<Thread>();
  final AtomicBoolean stop=new AtomicBoolean();
  final Set<Revision> set=Collections.synchronizedSet(new HashSet<Revision>());
  final Revision[] duplicate=new Revision[1];
  for (int i=0; i < 20; i++) {
    Thread thread=new Thread(new Runnable(){
      @Override public void run(){
        Revision[] last=new Revision[1024];
        while (!stop.get()) {
          for (          Revision r : last) {
            set.remove(r);
          }
          for (int i=0; i < last.length; i++) {
            last[i]=Revision.newRevision(1);
          }
          for (          Revision r : last) {
            if (!set.add(r)) {
              duplicate[0]=r;
            }
          }
        }
      }
    }
);
    thread.start();
    threads.add(thread);
  }
  Thread.sleep(200);
  stop.set(true);
  for (  Thread t : threads) {
    t.join();
  }
  assertNull("Duplicate revision",duplicate[0]);
}
