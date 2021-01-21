@Test public void testNullPrincipal() throws Exception {
  try {
    Privilege[] privs=new Privilege[]{acMgr.privilegeFromName(PrivilegeConstants.JCR_ALL)};
    createEntry(null,privs,true);
    fail("Principal must not be null");
  }
 catch (  AccessControlException e) {
  }
}
