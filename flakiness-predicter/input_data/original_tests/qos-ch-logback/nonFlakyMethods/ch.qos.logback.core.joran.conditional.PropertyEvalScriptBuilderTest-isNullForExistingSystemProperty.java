@Test public void isNullForExistingSystemProperty() throws Exception {
  System.setProperty(k,v);
  buildAndAssertFalse(isNullScriptStr);
}
