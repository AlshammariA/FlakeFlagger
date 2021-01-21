@Test public void testNamespaceRegistry() throws RepositoryException {
  NamespaceRegistry nsReg=getAdminSession().getWorkspace().getNamespaceRegistry();
  assertFalse(asList(nsReg.getPrefixes()).contains("foo"));
  assertFalse(asList(nsReg.getURIs()).contains("file:///foo"));
  nsReg.registerNamespace("foo","file:///foo");
  assertTrue(asList(nsReg.getPrefixes()).contains("foo"));
  assertTrue(asList(nsReg.getURIs()).contains("file:///foo"));
  nsReg.unregisterNamespace("foo");
  assertFalse(asList(nsReg.getPrefixes()).contains("foo"));
  assertFalse(asList(nsReg.getURIs()).contains("file:///foo"));
}
