@Test public void testRetainMatchingWithNoMatchingPattern() throws Exception {
  Collection<String> values=stringToList("A");
  StringCollectionUtil.retainMatching(values,"B");
  assertTrue(values.isEmpty());
}
