@Test public void testGetAuthorizable() throws Exception {
  UserProvider up=createUserProvider();
  String userID="hannah";
  String groupID="cLevel";
  Tree user=up.createUser(userID,null);
  Tree group=up.createGroup(groupID,null);
  root.commit();
  Tree a=up.getAuthorizable(userID);
  assertNotNull(a);
  assertEquals(user.getPath(),a.getPath());
  a=up.getAuthorizable(groupID);
  assertNotNull(a);
  assertEquals(group.getPath(),a.getPath());
}
