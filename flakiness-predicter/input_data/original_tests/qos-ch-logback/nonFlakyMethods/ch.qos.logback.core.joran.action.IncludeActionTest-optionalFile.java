@Test public void optionalFile() throws JoranException {
  tc.doConfigure(TOP_OPTIONAL);
  verifyConfig(new String[]{"IA","IB"});
  StatusPrinter.print(context);
}
