@Test public void existingContextPropertyShouldEvaluateToTrue() throws Exception {
  context.putProperty(k,v);
  buildAndAssertTrue(containsScript);
}
