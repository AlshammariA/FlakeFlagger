@Test public void existingLocalPropertyShouldEvaluateToTrue() throws Exception {
  localPropContainer.addSubstitutionProperty(k,v);
  buildAndAssertTrue(containsScript);
}
