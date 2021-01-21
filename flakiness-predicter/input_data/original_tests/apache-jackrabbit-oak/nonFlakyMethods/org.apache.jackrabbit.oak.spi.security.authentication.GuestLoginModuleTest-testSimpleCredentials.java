@Test public void testSimpleCredentials() throws LoginException {
  Subject subject=new Subject();
  CallbackHandler cbh=new TestCallbackHandler(new SimpleCredentials("test",new char[0]));
  Map sharedState=new HashMap();
  guestLoginModule.initialize(subject,cbh,sharedState,Collections.<String,Object>emptyMap());
  assertFalse(guestLoginModule.login());
  assertFalse(sharedState.containsKey(AbstractLoginModule.SHARED_KEY_CREDENTIALS));
  assertFalse(guestLoginModule.commit());
  assertTrue(subject.getPrincipals().isEmpty());
  assertTrue(subject.getPublicCredentials().isEmpty());
}
