@Test public void testRemoveMatchingWithMatchingPattern() throws Exception {
  Collection<String> values=stringToList("A");
  StringCollectionUtil.removeMatching(values,"A");
  assertTrue(values.isEmpty());
}
