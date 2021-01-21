@Test public void testUserContent() throws Exception {
  Authorizable a=userMgr.getAuthorizable(UserUtil.getAdminId(config));
  assertTrue(root.getTree(a.getPath()).exists());
  a=userMgr.getAuthorizable(UserUtil.getAnonymousId(config));
  assertTrue(root.getTree(a.getPath()).exists());
}
