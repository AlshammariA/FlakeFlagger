@Test public void testModified() throws Exception {
  Node child=superuser.getNode(path).addNode("child");
  superuser.save();
  allow(path,privilegesFromName(PrivilegeConstants.JCR_READ));
  Node n=testSession.getNode(path);
  assertFalse(n.isModified());
}
