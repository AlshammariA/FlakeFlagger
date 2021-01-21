@Test public void testGetAuthorizableId() throws Exception {
  UserProvider up=createUserProvider();
  String userID="Amanda";
  Tree user=up.createUser(userID,null);
  assertEquals(userID,UserUtil.getAuthorizableId(user));
  String groupID="visitors";
  Tree group=up.createGroup(groupID,null);
  assertEquals(groupID,UserUtil.getAuthorizableId(group));
}
