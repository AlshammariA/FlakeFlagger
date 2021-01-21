@Test public void testGetSharedCredentials(){
  Map<String,Object> sharedState=new HashMap<String,Object>();
  sharedState.put(AbstractLoginModule.SHARED_KEY_CREDENTIALS,new TestCredentials());
  AbstractLoginModule lm=initLoginModule(TestCredentials.class,sharedState);
  assertTrue(lm.getSharedCredentials() instanceof TestCredentials);
  sharedState.put(AbstractLoginModule.SHARED_KEY_CREDENTIALS,new SimpleCredentials("test","test".toCharArray()));
  lm=initLoginModule(TestCredentials.class,sharedState);
  assertTrue(lm.getSharedCredentials() instanceof SimpleCredentials);
  lm=initLoginModule(SimpleCredentials.class,sharedState);
  assertTrue(lm.getSharedCredentials() instanceof SimpleCredentials);
  sharedState.put(AbstractLoginModule.SHARED_KEY_CREDENTIALS,"no credentials object");
  lm=initLoginModule(TestCredentials.class,sharedState);
  assertNull(lm.getSharedCredentials());
  sharedState.clear();
  lm=initLoginModule(TestCredentials.class,sharedState);
  assertNull(lm.getSharedCredentials());
}
