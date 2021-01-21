@Test public void testTestSessionHasPrivileges() throws Exception {
  setupPolicy(testPath);
  root.commit();
  AccessControlManagerImpl testAcMgr=getTestAccessControlManager();
  List<Privilege[]> granted=new ArrayList<Privilege[]>();
  granted.add(privilegesFromNames(PrivilegeConstants.JCR_READ));
  granted.add(privilegesFromNames(PrivilegeConstants.REP_READ_NODES));
  granted.add(privilegesFromNames(PrivilegeConstants.REP_READ_PROPERTIES));
  granted.add(privilegesFromNames(PrivilegeConstants.JCR_ADD_CHILD_NODES));
  granted.add(testPrivileges);
  for (  Privilege[] privileges : granted) {
    assertTrue(testAcMgr.hasPrivileges(testPath,privileges));
    assertTrue(testAcMgr.hasPrivileges(testPath,getPrincipals(getTestRoot().getContentSession()),privileges));
  }
  List<Privilege[]> denied=new ArrayList<Privilege[]>();
  denied.add(privilegesFromNames(PrivilegeConstants.JCR_ALL));
  denied.add(privilegesFromNames(PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
  denied.add(privilegesFromNames(PrivilegeConstants.JCR_WRITE));
  denied.add(privilegesFromNames(PrivilegeConstants.JCR_LOCK_MANAGEMENT));
  for (  Privilege[] privileges : denied) {
    assertFalse(testAcMgr.hasPrivileges(testPath,privileges));
    assertFalse(testAcMgr.hasPrivileges(testPath,getPrincipals(getTestRoot().getContentSession()),privileges));
  }
}
