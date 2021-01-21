@Test public void sessionRemappedNamespace() throws RepositoryException {
  NamespaceRegistry nsReg=getAdminSession().getWorkspace().getNamespaceRegistry();
  nsReg.registerNamespace("foo","file:///foo");
  getAdminSession().getRootNode().addNode("foo:test");
  getAdminSession().save();
  Session s=createAdminSession();
  s.setNamespacePrefix("bar","file:///foo");
  assertTrue(s.getRootNode().hasNode("bar:test"));
  Node n=s.getRootNode().getNode("bar:test");
  assertEquals("bar:test",n.getName());
  s.logout();
  getAdminSession().getRootNode().getNode("foo:test").remove();
  getAdminSession().save();
  nsReg.unregisterNamespace("foo");
}
