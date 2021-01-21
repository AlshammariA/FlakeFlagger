@Test public void testPrivilegeFromExpandedName() throws Exception {
  Privilege readPriv=getPrivilegeManager(root).getPrivilege(PrivilegeConstants.JCR_READ);
  assertEquals(readPriv,acMgr.privilegeFromName(Privilege.JCR_READ));
}
