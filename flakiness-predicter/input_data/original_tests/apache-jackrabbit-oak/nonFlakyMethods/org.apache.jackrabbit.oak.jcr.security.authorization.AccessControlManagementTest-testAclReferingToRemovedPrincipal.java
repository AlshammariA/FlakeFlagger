@Test public void testAclReferingToRemovedPrincipal() throws Exception {
  JackrabbitAccessControlList acl=allow(path,repWritePrivileges);
  String acPath=acl.getPath();
  testUser.remove();
  superuser.save();
  testUser=null;
  Session s=getHelper().getSuperuserSession();
  try {
    AccessControlManager acMgr=getAccessControlManager(s);
    acMgr.getPolicies(acPath);
  }
  finally {
    s.logout();
  }
}
