@Test public void testPasswordValidationActionOnCreate() throws Exception {
  String hashed=PasswordUtil.buildPasswordHash("DWkej32H");
  testUser=getUserManager(root).createUser("testuser",hashed);
  root.commit();
  String pwValue=root.getTree(testUser.getPath()).getProperty(UserConstants.REP_PASSWORD).getValue(Type.STRING);
  assertFalse(PasswordUtil.isPlainTextPassword(pwValue));
  assertTrue(PasswordUtil.isSame(pwValue,hashed));
}
