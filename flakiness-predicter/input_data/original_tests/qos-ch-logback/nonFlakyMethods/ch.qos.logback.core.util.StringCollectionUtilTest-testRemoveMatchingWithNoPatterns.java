@Test public void testRemoveMatchingWithNoPatterns() throws Exception {
  Collection<String> values=stringToList("A");
  StringCollectionUtil.removeMatching(values);
  assertTrue(values.contains("A"));
}
