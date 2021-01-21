@Test public void testRemoveMixin() throws Exception {
  Node n=superuser.getNode(path);
  deny(path,readPrivileges);
  assertTrue(n.hasNode("rep:policy"));
  assertTrue(n.isNodeType("rep:AccessControllable"));
  n.removeMixin("rep:AccessControllable");
  superuser.save();
  assertFalse(n.hasNode("rep:policy"));
  assertFalse(n.isNodeType("rep:AccessControllable"));
}
