@Test public void testNullPassword() throws Exception {
  try {
    pwChangeAction.onPasswordChange(getTestUser(),null,root,getNamePathMapper());
    fail("ConstraintViolationException expected.");
  }
 catch (  ConstraintViolationException e) {
  }
}
