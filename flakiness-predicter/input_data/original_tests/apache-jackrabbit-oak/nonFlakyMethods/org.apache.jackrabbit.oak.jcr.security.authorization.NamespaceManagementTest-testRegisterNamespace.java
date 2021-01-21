@Test public void testRegisterNamespace() throws Exception {
  try {
    Workspace testWsp=testSession.getWorkspace();
    testWsp.getNamespaceRegistry().registerNamespace(getNewNamespacePrefix(testWsp),getNewNamespaceURI(testWsp));
    fail("Namespace registration should be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
