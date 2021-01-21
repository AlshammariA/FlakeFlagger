@Test public void testAccessDisabledUser() throws Exception {
  user.disable("readonly user is disabled!");
  superuser.save();
  assertNotNull(getUserManager(superuser).getAuthorizable(user.getID()));
  assertTrue(((JackrabbitSession)superuser).getPrincipalManager().hasPrincipal(user.getPrincipal().getName()));
}
