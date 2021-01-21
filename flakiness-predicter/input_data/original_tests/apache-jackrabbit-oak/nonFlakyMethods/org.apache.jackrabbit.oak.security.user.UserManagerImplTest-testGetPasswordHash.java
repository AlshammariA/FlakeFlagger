@Test public void testGetPasswordHash() throws Exception {
  User user=userMgr.createUser(testUserId,null);
  root.commit();
  Tree userTree=root.getTree(user.getPath());
  assertNull(userTree.getProperty(UserConstants.REP_PASSWORD));
}
