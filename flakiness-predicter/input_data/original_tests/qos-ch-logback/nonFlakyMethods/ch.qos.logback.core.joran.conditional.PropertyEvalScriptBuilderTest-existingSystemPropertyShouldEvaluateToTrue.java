@Test public void existingSystemPropertyShouldEvaluateToTrue() throws Exception {
  System.setProperty(k,v);
  buildAndAssertTrue(containsScript);
}
