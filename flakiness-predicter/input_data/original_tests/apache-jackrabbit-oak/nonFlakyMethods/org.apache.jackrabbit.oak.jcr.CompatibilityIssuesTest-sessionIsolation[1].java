/** 
 * Trans-session isolation differs from Jackrabbit 2. Snapshot isolation can result in write skew as this test demonstrates: the check method enforces an application logic constraint which says that the sum of the properties p1 and p2 must not be negative. While session1 and session2 each enforce this constraint before saving, the constraint might not hold globally as can be seen in session3.
 * @see <a href="http://wiki.apache.org/jackrabbit/Transactional%20model%20of%20the%20Microkernel%20based%20Jackrabbit%20prototype">
     *     Transactional model of the Microkernel based Jackrabbit prototype</a>
 */
@Test public void sessionIsolation() throws RepositoryException, ExecutionException, InterruptedException {
  final Session session0=createAdminSession();
  try {
    run(new Callable<Void>(){
      @Override public Void call() throws Exception {
        Node testNode=session0.getNode("/").addNode("testNode");
        testNode.setProperty("p1",1);
        testNode.setProperty("p2",1);
        session0.save();
        check(getAdminSession());
        return null;
      }
    }
);
  }
  finally {
    session0.logout();
  }
  final Session session1=createAdminSession();
  final Session session2=createAdminSession();
  try {
    run(new Callable<Void>(){
      @Override public Void call() throws Exception {
        session1.getNode("/testNode").setProperty("p1",-1);
        check(session1);
        session1.save();
        return null;
      }
    }
);
    run(new Callable<Void>(){
      @Override public Void call() throws Exception {
        session2.getNode("/testNode").setProperty("p2",-1);
        check(session2);
        session2.save();
        return null;
      }
    }
);
  }
  finally {
    session1.logout();
    session2.logout();
  }
  Session session3=createAnonymousSession();
  try {
    check(session3);
    fail();
  }
 catch (  AssertionError e) {
  }
 finally {
    session3.logout();
  }
}
