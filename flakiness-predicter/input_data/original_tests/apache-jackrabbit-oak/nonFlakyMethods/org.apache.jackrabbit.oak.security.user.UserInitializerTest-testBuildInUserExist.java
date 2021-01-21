@Test public void testBuildInUserExist() throws Exception {
  assertNotNull(userMgr.getAuthorizable(UserUtil.getAdminId(config)));
  assertNotNull(userMgr.getAuthorizable(UserUtil.getAnonymousId(config)));
}
