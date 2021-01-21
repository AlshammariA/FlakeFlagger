@Test public void testGetCredentialsFromSharedState(){
  Map<String,Credentials> sharedState=new HashMap<String,Credentials>();
  sharedState.put(AbstractLoginModule.SHARED_KEY_CREDENTIALS,new TestCredentials());
  AbstractLoginModule lm=initLoginModule(TestCredentials.class,sharedState);
  assertTrue(lm.getCredentials() instanceof TestCredentials);
  SimpleCredentials sc=new SimpleCredentials("test","test".toCharArray());
  sharedState.put(AbstractLoginModule.SHARED_KEY_CREDENTIALS,sc);
  lm=initLoginModule(TestCredentials.class,sharedState);
  assertNull(lm.getCredentials());
  sharedState.put(AbstractLoginModule.SHARED_KEY_CREDENTIALS,sc);
  lm=initLoginModule(SimpleCredentials.class,sharedState);
  assertTrue(lm.getCredentials() instanceof SimpleCredentials);
  sharedState.clear();
  lm=initLoginModule(TestCredentials.class,sharedState);
  assertNull(lm.getCredentials());
}
