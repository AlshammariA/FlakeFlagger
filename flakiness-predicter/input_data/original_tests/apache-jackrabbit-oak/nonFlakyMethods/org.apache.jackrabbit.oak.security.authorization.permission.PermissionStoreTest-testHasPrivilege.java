@Test public void testHasPrivilege(){
  PermissionProvider pp=createPermissionProvider();
  Tree t=root.getTree(PermissionConstants.PERMISSIONS_STORE_PATH);
  assertFalse(pp.hasPrivileges(t,PrivilegeConstants.JCR_READ));
}
