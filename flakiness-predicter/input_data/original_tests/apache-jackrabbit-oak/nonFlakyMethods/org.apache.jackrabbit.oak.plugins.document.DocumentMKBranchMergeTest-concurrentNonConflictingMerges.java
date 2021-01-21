@Test public void concurrentNonConflictingMerges() throws Exception {
  int numThreads=10;
  mk.commit("/","+\"test\":{}",null,null);
  List<Thread> workers=new ArrayList<Thread>();
  final List<Exception> exceptions=Collections.synchronizedList(new ArrayList<Exception>());
  for (int i=0; i < numThreads; i++) {
    final String path="/test/t" + i;
    mk.commit("","+\"" + path + "\":{}",null,null);
    workers.add(new Thread(new Runnable(){
      @Override public void run(){
        try {
          for (int i=0; i < 50; i++) {
            String branchRev=mk.branch(null);
            branchRev=mk.commit(path,"+\"node" + i + "\":{}",branchRev,null);
            mk.merge(branchRev,null);
          }
        }
 catch (        MicroKernelException e) {
          exceptions.add(e);
        }
      }
    }
));
  }
  for (  Thread t : workers) {
    t.start();
  }
  for (  Thread t : workers) {
    t.join();
  }
  if (!exceptions.isEmpty()) {
    throw exceptions.get(0);
  }
}
