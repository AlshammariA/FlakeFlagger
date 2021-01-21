@Test public void testGetPrivilege(){
  PermissionProvider pp=createPermissionProvider();
  Tree t=root.getTree(PermissionConstants.PERMISSIONS_STORE_PATH);
  Set<String> privilegeNames=pp.getPrivileges(t);
  assertTrue(privilegeNames.isEmpty());
}
