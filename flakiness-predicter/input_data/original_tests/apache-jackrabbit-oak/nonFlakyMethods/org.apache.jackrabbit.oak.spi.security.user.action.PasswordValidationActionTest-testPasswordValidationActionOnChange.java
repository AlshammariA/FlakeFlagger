@Test public void testPasswordValidationActionOnChange() throws Exception {
  testUser=getUserManager(root).createUser("testuser","testPw123456");
  root.commit();
  try {
    pwAction.init(getSecurityProvider(),ConfigurationParameters.of(Collections.singletonMap(PasswordValidationAction.CONSTRAINT,"abc")));
    String hashed=PasswordUtil.buildPasswordHash("abc");
    testUser.changePassword(hashed);
    fail("Password change must always enforce password validation.");
  }
 catch (  ConstraintViolationException e) {
  }
}
