/** 
 * Simulate a 'rename' call using 3 sessions: - 1st create a node that has a '.tmp' extension  - 2nd remove the '.tmp' by issuing a Session#move call on a new session - 3rd verify the move by issuing a #getNode call on the destination path using a new session
 */
@Test public void testOak898() throws Exception {
  String name="testMove";
  Node node=testRootNode.addNode(name + ".tmp");
  superuser.save();
  String destPath=testRootNode.getPath() + '/' + name;
  Session session2=getHelper().getSuperuserSession();
  try {
    assertFalse(session2.hasPendingChanges());
    session2.move(node.getPath(),destPath);
    assertTrue(session2.hasPendingChanges());
    session2.save();
  }
  finally {
    session2.logout();
  }
  Session session3=getHelper().getSuperuserSession();
  try {
    assertNotNull(session3.getNode(destPath));
  }
  finally {
    session3.logout();
  }
}
