@Test public void testModifyPrivilegeMgtPrivilege() throws Exception {
  modify(null,PrivilegeConstants.REP_PRIVILEGE_MANAGEMENT,true);
  assertHasRepoPrivilege(PrivilegeConstants.REP_PRIVILEGE_MANAGEMENT,true);
  modify(null,PrivilegeConstants.REP_PRIVILEGE_MANAGEMENT,false);
  assertHasRepoPrivilege(PrivilegeConstants.REP_PRIVILEGE_MANAGEMENT,false);
}
