@Test public void isNullForExistingLocalProperty() throws Exception {
  localPropContainer.addSubstitutionProperty(k,v);
  buildAndAssertFalse(isNullScriptStr);
}
