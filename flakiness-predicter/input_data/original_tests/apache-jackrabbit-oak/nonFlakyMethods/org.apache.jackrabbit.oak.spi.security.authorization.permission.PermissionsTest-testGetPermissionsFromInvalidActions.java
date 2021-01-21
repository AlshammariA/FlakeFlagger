@Test public void testGetPermissionsFromInvalidActions(){
  TreeLocation tl=TreeLocation.create(root.getTree("/"));
  List<String> l=ImmutableList.of(Session.ACTION_READ + ",invalid","invalid","invalid," + Session.ACTION_REMOVE);
  for (  String invalid : l) {
    try {
      Permissions.getPermissions(invalid,tl,false);
      fail();
    }
 catch (    IllegalArgumentException e) {
    }
  }
}
