@Test public void basicResource() throws JoranException {
  System.setProperty(INCLUDE_KEY,INCLUDED_AS_RESOURCE);
  tc.doConfigure(INCLUDE_BY_RESOURCE);
  verifyConfig(new String[]{"AR_A","AR_B"});
}
