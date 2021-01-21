@Test public void testEnableUser() throws Exception {
  user.disable("readonly user is disabled!");
  superuser.save();
  user.disable(null);
  superuser.save();
  assertFalse(user.isDisabled());
  assertNull(user.getDisabledReason());
  getHelper().getRepository().login(new SimpleCredentials(user.getID(),"pw".toCharArray())).logout();
}
