@Test public void testGetAuthorizableByPath() throws Exception {
  UserProvider up=createUserProvider();
  Tree user=up.createUser("shams",null);
  Tree a=up.getAuthorizableByPath(user.getPath());
  assertNotNull(a);
  assertEquals(user.getPath(),a.getPath());
  Tree group=up.createGroup("devs",null);
  a=up.getAuthorizableByPath(group.getPath());
  assertNotNull(a);
  assertEquals(group.getPath(),a.getPath());
}
