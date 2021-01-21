@Test public void testGetCredentialsFromCallbackHandler(){
  CallbackHandler cbh=new CallbackHandler(){
    @Override public void handle(    Callback[] callbacks){
      for (      Callback cb : callbacks) {
        if (cb instanceof CredentialsCallback) {
          ((CredentialsCallback)cb).setCredentials(new TestCredentials());
        }
      }
    }
  }
;
  AbstractLoginModule lm=initLoginModule(TestCredentials.class,cbh);
  assertTrue(lm.getCredentials() instanceof TestCredentials);
  lm=initLoginModule(SimpleCredentials.class,cbh);
  assertNull(lm.getCredentials());
}
