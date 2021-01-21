@Test public void testUnregisterNamespace() throws Exception {
  Workspace wsp=superuser.getWorkspace();
  String pfx=getNewNamespacePrefix(wsp);
  wsp.getNamespaceRegistry().registerNamespace(pfx,getNewNamespaceURI(wsp));
  try {
    Workspace testWsp=testSession.getWorkspace();
    testWsp.getNamespaceRegistry().unregisterNamespace(pfx);
    fail("Namespace unregistration should be denied.");
  }
 catch (  AccessDeniedException e) {
  }
 finally {
    try {
      superuser.getWorkspace().getNamespaceRegistry().unregisterNamespace(pfx);
    }
 catch (    Exception e) {
    }
  }
}
