/** 
 * OAK-939 - Change in behaviour from JR2. Following test case leads to CommitFailedException but it passes in JR2
 */
@Test public void removeNodeInDifferentSession() throws Throwable {
  final String testNode="test_node";
  final String testNodePath='/' + testNode;
  Session session=getAdminSession();
  session.getRootNode().addNode(testNode);
  session.save();
  boolean refreshIntervalZero=false;
  Session s3=newSession(refreshIntervalZero);
  Session s2=newSession(refreshIntervalZero);
  s2.getNode(testNodePath).setProperty("foo","bar");
  s2.save();
  s3.getNode(testNodePath).remove();
  try {
    s3.save();
  }
 catch (  InvalidItemStateException e) {
    assertTrue(e.getCause() instanceof CommitFailedException);
  }
}
