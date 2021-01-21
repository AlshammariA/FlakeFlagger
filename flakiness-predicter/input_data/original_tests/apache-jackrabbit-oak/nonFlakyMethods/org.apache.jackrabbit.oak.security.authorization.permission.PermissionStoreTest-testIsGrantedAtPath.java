@Test public void testIsGrantedAtPath(){
  PermissionProvider pp=createPermissionProvider();
  assertFalse(pp.isGranted(PermissionConstants.PERMISSIONS_STORE_PATH,Session.ACTION_READ));
  assertFalse(pp.isGranted(PermissionConstants.PERMISSIONS_STORE_PATH,Session.ACTION_ADD_NODE));
}
