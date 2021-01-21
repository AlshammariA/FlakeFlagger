@Test public void testModified2() throws Exception {
  Node child=superuser.getNode(path).addNode("child");
  superuser.save();
  deny(child.getPath(),privilegesFromName(PrivilegeConstants.JCR_READ));
  Node n=testSession.getNode(path);
  assertFalse(n.isModified());
}
