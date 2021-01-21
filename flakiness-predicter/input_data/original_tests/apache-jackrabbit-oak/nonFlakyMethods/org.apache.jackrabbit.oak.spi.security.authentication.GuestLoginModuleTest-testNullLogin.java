@Test public void testNullLogin() throws LoginException {
  Subject subject=new Subject();
  CallbackHandler cbh=new TestCallbackHandler(null);
  Map sharedState=new HashMap();
  guestLoginModule.initialize(subject,cbh,sharedState,Collections.<String,Object>emptyMap());
  assertTrue(guestLoginModule.login());
  Object sharedCreds=sharedState.get(AbstractLoginModule.SHARED_KEY_CREDENTIALS);
  assertNotNull(sharedCreds);
  assertTrue(sharedCreds instanceof GuestCredentials);
  assertTrue(guestLoginModule.commit());
  assertFalse(subject.getPrincipals(EveryonePrincipal.class).isEmpty());
  assertFalse(subject.getPublicCredentials(GuestCredentials.class).isEmpty());
}
