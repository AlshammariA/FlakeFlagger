@Test public void testImportUnknownPrincipal() throws Exception {
  try {
    runImport();
    AccessControlManager acMgr=adminSession.getAccessControlManager();
    AccessControlPolicy[] policies=acMgr.getPolicies(target.getPath());
    assertEquals(1,policies.length);
    assertEquals(0,((AccessControlList)policies[0]).getAccessControlEntries().length);
  }
  finally {
    adminSession.refresh(false);
  }
}
