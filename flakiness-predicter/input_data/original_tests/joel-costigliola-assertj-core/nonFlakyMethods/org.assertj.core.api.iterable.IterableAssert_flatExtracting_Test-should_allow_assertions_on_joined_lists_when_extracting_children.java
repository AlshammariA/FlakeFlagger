@Test public void should_allow_assertions_on_joined_lists_when_extracting_children(){
  assertThat(newArrayList(homer,fred)).flatExtracting(children).containsOnly(bart,lisa,maggie,pebbles);
}
