@Test public void inexistentPropertyShouldEvaluateToFalse() throws Exception {
  buildAndAssertFalse(containsScript);
}
