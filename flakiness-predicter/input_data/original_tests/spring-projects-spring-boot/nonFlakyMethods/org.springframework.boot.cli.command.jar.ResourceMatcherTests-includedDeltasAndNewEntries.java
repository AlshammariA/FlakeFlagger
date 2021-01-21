@SuppressWarnings("unchecked") @Test public void includedDeltasAndNewEntries() throws Exception {
  ResourceMatcher resourceMatcher=new ResourceMatcher(Arrays.asList("-static/**","foo.jar"),Arrays.asList("-**/*.jar"));
  Collection<String> includes=(Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"includes");
  assertTrue(includes.contains("foo.jar"));
  assertTrue(includes.contains("templates/**"));
  assertFalse(includes.contains("static/**"));
  assertFalse(((Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"excludes")).contains("**/*.jar"));
}
