@Test public void multiInclude() throws JoranException {
  System.setProperty(INCLUDE_KEY,INCLUDED_FILE);
  System.setProperty(SECOND_FILE_KEY,SECOND_FILE);
  tc.doConfigure(MULTI_INCLUDE_BY_FILE);
  verifyConfig(new String[]{"IA","IB","SECOND"});
}
