@Test public void testWriteOnParentWithNoReadePriv() throws Exception {
  Node a=superuser.getNode(path).addNode("a");
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(a.getPath(),testUser.getPrincipal(),readPrivileges);
  superuser.save();
  testSession.getNode(path).addNode("a");
}
