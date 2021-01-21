@Test public void renameNonOrderable() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  Node parent=root.addNode("parent",NodeTypeConstants.NT_OAK_UNSTRUCTURED);
  parent.addNode("fo");
  Node foo=parent.addNode("foo");
  session.save();
  ((JackrabbitNode)foo).rename("renamed");
  assertEquals("renamed",foo.getName());
  assertFalse(session.nodeExists("/parent/foo"));
  assertTrue(session.nodeExists("/parent/renamed"));
}
