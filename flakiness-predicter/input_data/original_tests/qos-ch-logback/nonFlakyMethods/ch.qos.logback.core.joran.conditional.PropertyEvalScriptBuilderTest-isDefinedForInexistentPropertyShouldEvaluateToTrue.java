@Test public void isDefinedForInexistentPropertyShouldEvaluateToTrue() throws Exception {
  buildAndAssertFalse(isDefiedScriptStr);
}
