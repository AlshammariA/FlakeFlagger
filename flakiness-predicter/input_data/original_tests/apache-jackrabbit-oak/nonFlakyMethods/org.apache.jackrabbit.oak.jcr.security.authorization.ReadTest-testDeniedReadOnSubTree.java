@Test public void testDeniedReadOnSubTree() throws Exception {
  deny(childNPath,readPrivileges);
  assertTrue(testSession.hasPermission(path,Session.ACTION_READ));
  Node n=testSession.getNode(path);
  testSession.getNode(childNPath2);
  assertTrue(n.getProperties().hasNext());
  assertFalse(testSession.itemExists(childNPath));
  try {
    testSession.getNode(childNPath);
    fail("Read access has been denied -> cannot retrieve child node.");
  }
 catch (  PathNotFoundException e) {
  }
  assertFalse(testSession.itemExists(childchildPPath));
  try {
    testSession.getItem(childchildPPath);
    fail("Read access has been denied -> cannot retrieve prop below child node.");
  }
 catch (  PathNotFoundException e) {
  }
}
