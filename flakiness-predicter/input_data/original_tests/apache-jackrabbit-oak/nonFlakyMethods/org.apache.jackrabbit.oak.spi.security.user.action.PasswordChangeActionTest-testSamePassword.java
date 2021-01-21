@Test public void testSamePassword() throws Exception {
  try {
    User user=getTestUser();
    String pw=user.getID();
    pwChangeAction.onPasswordChange(user,pw,root,getNamePathMapper());
    fail("ConstraintViolationException expected.");
  }
 catch (  ConstraintViolationException e) {
  }
}
