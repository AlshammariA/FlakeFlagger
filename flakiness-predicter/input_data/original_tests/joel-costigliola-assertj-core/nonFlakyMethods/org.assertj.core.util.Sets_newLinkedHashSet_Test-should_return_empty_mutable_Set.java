@Test public void should_return_empty_mutable_Set(){
  LinkedHashSet<Object> set=Sets.newLinkedHashSet();
  assertThat(set).isEmpty();
  set.add("element");
  assertThat(set).containsExactly("element");
}
