@Test public void testRetainMatchingWithMatchingPattern() throws Exception {
  Collection<String> values=stringToList("A");
  StringCollectionUtil.retainMatching(values,"A");
  assertTrue(values.contains("A"));
}
