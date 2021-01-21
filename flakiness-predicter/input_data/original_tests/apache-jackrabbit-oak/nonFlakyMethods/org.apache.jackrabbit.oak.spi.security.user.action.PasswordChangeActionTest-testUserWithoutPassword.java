@Test public void testUserWithoutPassword() throws Exception {
  String uid="testUser" + UUID.randomUUID();
  User user=getUserManager(root).createUser(uid,null);
  pwChangeAction.onPasswordChange(user,"changedPassword",root,getNamePathMapper());
}
