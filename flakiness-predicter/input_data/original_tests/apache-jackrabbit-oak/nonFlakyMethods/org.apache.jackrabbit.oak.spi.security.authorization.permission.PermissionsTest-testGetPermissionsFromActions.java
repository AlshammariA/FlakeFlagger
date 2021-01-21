@Test public void testGetPermissionsFromActions(){
  TreeLocation tl=TreeLocation.create(root.getTree("/"));
  Map<String,Long> map=ImmutableMap.of(Session.ACTION_READ,Permissions.READ_NODE,Session.ACTION_READ + "," + Session.ACTION_REMOVE,Permissions.READ_NODE | Permissions.REMOVE_NODE);
  for (  Map.Entry<String,Long> entry : map.entrySet()) {
    assertEquals(entry.getValue().longValue(),Permissions.getPermissions(entry.getKey(),tl,false));
  }
}
