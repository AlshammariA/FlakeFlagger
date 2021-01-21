@Test public void testIsGranted(){
  PermissionProvider pp=createPermissionProvider();
  Tree t=root.getTree(PermissionConstants.PERMISSIONS_STORE_PATH);
  assertFalse(pp.isGranted(t,null,Permissions.READ));
  assertFalse(pp.isGranted(t,t.getProperty(JcrConstants.JCR_PRIMARYTYPE),Permissions.READ));
}
