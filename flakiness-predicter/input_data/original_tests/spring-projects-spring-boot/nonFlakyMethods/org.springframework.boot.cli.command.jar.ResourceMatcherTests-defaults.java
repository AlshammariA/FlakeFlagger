@SuppressWarnings("unchecked") @Test public void defaults() throws Exception {
  ResourceMatcher resourceMatcher=new ResourceMatcher(Arrays.asList(""),Arrays.asList(""));
  assertTrue(((Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"includes")).contains("static/**"));
  assertTrue(((Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"excludes")).contains("**/*.jar"));
}
