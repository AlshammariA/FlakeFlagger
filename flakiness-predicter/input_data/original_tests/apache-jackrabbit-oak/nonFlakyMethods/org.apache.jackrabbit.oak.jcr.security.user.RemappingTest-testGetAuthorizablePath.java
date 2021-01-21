@Test public void testGetAuthorizablePath() throws Exception {
  assertTrue(user.getPath().startsWith(UserConstants.DEFAULT_USER_PATH));
  String path=authorizable.getPath();
  assertFalse(path.startsWith(UserConstants.DEFAULT_USER_PATH));
}
