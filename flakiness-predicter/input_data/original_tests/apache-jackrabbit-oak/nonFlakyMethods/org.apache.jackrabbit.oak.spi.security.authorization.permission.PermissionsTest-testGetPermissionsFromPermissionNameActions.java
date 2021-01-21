@Test public void testGetPermissionsFromPermissionNameActions(){
  TreeLocation tl=TreeLocation.create(root.getTree("/"));
  long permissions=Permissions.NODE_TYPE_MANAGEMENT | Permissions.LOCK_MANAGEMENT | Permissions.VERSION_MANAGEMENT;
  Set<String> names=Permissions.getNames(permissions);
  String jcrActions=Text.implode(names.toArray(new String[names.size()]),",");
  assertEquals(permissions,Permissions.getPermissions(jcrActions,tl,false));
}
