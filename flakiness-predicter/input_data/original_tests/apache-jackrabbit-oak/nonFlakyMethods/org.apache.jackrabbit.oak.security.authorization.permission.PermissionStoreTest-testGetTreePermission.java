@Test public void testGetTreePermission(){
  PermissionProvider pp=createPermissionProvider();
  Tree t=root.getTree(PermissionConstants.PERMISSIONS_STORE_PATH);
  assertSame(TreePermission.EMPTY,pp.getTreePermission(t,TreePermission.EMPTY));
}
