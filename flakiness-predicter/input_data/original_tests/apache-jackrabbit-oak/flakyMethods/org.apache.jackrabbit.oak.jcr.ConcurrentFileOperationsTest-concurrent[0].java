/** 
 * Multiple threads create and rename files.
 */
@Test public void concurrent() throws Exception {
  List<Session> sessions=new ArrayList<Session>();
  for (int i=0; i < NUM_WRITERS; i++) {
    sessions.add(createAdminSession());
    testRootNode.addNode("session-" + i,"nt:unstructured");
  }
  addFile(testRootNode,"dummy");
  session.save();
  final Map<String,Exception> exceptions=Collections.synchronizedMap(new HashMap<String,Exception>());
  List<Thread> writers=new ArrayList<Thread>();
  for (int i=0; i < sessions.size(); i++) {
    final Session s=sessions.get(i);
    final String path=testRootNode.getPath() + "/session-" + i;
    writers.add(new Thread(new Runnable(){
      @Override public void run(){
        try {
          s.refresh(false);
          Node n=s.getNode(path);
          for (int i=0; i < 10; i++) {
            String tmpFile="file-" + i + ".tmp";
            addFile(n,tmpFile);
            s.save();
            String srcPath=n.getPath() + "/" + tmpFile;
            String destPath=n.getPath() + "/file-" + i+ ".bin";
            s.move(srcPath,destPath);
            s.save();
          }
        }
 catch (        RepositoryException e) {
          exceptions.put(path,new Exception(dumpTree(s,path),e));
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
  for (  Session s : sessions) {
    s.logout();
  }
  for (  Map.Entry<String,Exception> entry : exceptions.entrySet()) {
    log.info("Worker (" + entry.getKey() + ") failed with exception: "+ entry.getValue().toString());
    throw entry.getValue();
  }
}
