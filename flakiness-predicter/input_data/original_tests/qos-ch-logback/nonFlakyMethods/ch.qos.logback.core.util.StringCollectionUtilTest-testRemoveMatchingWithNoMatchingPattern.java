@Test public void testRemoveMatchingWithNoMatchingPattern() throws Exception {
  Collection<String> values=stringToList("A");
  StringCollectionUtil.removeMatching(values,"B");
  assertTrue(values.contains("A"));
}
