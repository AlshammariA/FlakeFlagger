@Test public void should_allow_assertions_on_joined_lists_when_extracting_children_array(){
  assertThat(newArrayList(homer,fred)).flatExtracting("childrenArray").containsOnly(bart,lisa,maggie,pebbles);
}
