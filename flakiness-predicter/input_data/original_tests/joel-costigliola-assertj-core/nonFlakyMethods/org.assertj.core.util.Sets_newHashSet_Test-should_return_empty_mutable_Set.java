@Test public void should_return_empty_mutable_Set(){
  HashSet<Object> set=Sets.newHashSet();
  assertThat(set).isEmpty();
  set.add("element");
  assertThat(set).containsExactly("element");
}
