@Test public void registryRemappedNamespace() throws RepositoryException {
  NamespaceRegistry nsReg=getAdminSession().getWorkspace().getNamespaceRegistry();
  nsReg.registerNamespace("foo","file:///foo");
  getAdminSession().getRootNode().addNode("foo:test");
  getAdminSession().save();
  try {
    nsReg.registerNamespace("bar","file:///foo");
    fail("Remapping namespace through NamespaceRegistry must not be allowed");
  }
 catch (  NamespaceException e) {
  }
 finally {
    getAdminSession().getRootNode().getNode("foo:test").remove();
    getAdminSession().save();
    nsReg.unregisterNamespace("foo");
  }
}
