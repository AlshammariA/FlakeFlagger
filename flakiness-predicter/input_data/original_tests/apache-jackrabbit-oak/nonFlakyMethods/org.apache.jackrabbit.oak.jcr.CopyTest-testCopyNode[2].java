@Test public void testCopyNode() throws RepositoryException {
  Session session=getAdminSession();
  session.getWorkspace().copy(TEST_PATH + "/source/node",TEST_PATH + "/target/copied");
  assertTrue(testNode.hasNode("source/node"));
  assertTrue(testNode.hasNode("target/copied"));
}
