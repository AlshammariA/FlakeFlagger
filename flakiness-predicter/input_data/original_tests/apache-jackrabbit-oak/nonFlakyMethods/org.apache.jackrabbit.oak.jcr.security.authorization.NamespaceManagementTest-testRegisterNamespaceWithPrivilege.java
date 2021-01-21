@Test public void testRegisterNamespaceWithPrivilege() throws Exception {
  modify(null,PrivilegeConstants.JCR_NAMESPACE_MANAGEMENT.toString(),true);
  try {
    Workspace testWsp=testSession.getWorkspace();
    testWsp.getNamespaceRegistry().registerNamespace(getNewNamespacePrefix(testWsp),getNewNamespaceURI(testWsp));
  }
  finally {
    modify(null,PrivilegeConstants.JCR_NAMESPACE_MANAGEMENT.toString(),false);
  }
}
