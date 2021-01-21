@Test public void testGetTokenProvider(){
  CompositeTokenConfiguration ctc=(CompositeTokenConfiguration)getCompositeConfiguration();
  TokenProvider tp=ctc.getTokenProvider(root);
  assertNotNull(tp);
  assertFalse(tp instanceof CompositeTokenProvider);
  TokenConfiguration tc=new TokenConfigurationImpl(getSecurityProvider());
  setDefault(tc);
  tp=ctc.getTokenProvider(root);
  assertNotNull(tp);
  assertFalse(tp instanceof CompositeTokenProvider);
  assertTrue(tp instanceof TokenProviderImpl);
  addConfiguration(tc);
  tp=ctc.getTokenProvider(root);
  assertNotNull(tp);
  assertFalse(tp instanceof CompositeTokenProvider);
  assertTrue(tp instanceof TokenProviderImpl);
  addConfiguration(new TokenConfigurationImpl(getSecurityProvider()));
  tp=ctc.getTokenProvider(root);
  assertNotNull(tp);
  assertTrue(tp instanceof CompositeTokenProvider);
}
