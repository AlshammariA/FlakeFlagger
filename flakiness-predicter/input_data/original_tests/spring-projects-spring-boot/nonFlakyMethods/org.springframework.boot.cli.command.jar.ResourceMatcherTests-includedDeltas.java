@SuppressWarnings("unchecked") @Test public void includedDeltas() throws Exception {
  ResourceMatcher resourceMatcher=new ResourceMatcher(Arrays.asList("-static/**"),Arrays.asList(""));
  Collection<String> includes=(Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"includes");
  assertTrue(includes.contains("templates/**"));
  assertFalse(includes.contains("static/**"));
}
