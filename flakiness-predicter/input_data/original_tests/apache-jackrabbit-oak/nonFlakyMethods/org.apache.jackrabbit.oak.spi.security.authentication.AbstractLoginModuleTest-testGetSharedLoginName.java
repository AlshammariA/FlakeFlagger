@Test public void testGetSharedLoginName(){
  Map<String,String> sharedState=new HashMap<String,String>();
  sharedState.put(AbstractLoginModule.SHARED_KEY_LOGIN_NAME,"test");
  AbstractLoginModule lm=initLoginModule(TestCredentials.class,sharedState);
  assertEquals("test",lm.getSharedLoginName());
  sharedState.clear();
  lm=initLoginModule(TestCredentials.class,sharedState);
  assertNull(lm.getSharedLoginName());
}
