@Test public void testRemoveParentTree() throws Exception {
  UserProvider up=createUserProvider();
  Tree u1=up.createUser("b","b");
  Tree u2=up.createUser("bb","bb");
  Tree folder=root.getTree(Text.getRelativeParent(u1.getPath(),2));
  folder.remove();
  if (up.getAuthorizable("b") != null) {
    fail("Removing the top authorizable folder must remove all users contained.");
    u1.remove();
  }
  if (up.getAuthorizable("bb") != null) {
    fail("Removing the top authorizable folder must remove all users contained.");
    u2.remove();
  }
}
