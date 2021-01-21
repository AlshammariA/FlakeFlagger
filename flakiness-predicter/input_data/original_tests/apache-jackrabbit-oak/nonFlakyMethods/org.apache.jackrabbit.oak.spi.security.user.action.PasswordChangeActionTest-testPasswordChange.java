@Test public void testPasswordChange() throws Exception {
  pwChangeAction.onPasswordChange(getTestUser(),"changedPassword",root,getNamePathMapper());
}
