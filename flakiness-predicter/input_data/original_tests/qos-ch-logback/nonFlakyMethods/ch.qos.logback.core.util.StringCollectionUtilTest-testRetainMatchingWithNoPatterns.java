@Test public void testRetainMatchingWithNoPatterns() throws Exception {
  Collection<String> values=stringToList("A");
  StringCollectionUtil.retainMatching(values);
  assertTrue(values.contains("A"));
}
