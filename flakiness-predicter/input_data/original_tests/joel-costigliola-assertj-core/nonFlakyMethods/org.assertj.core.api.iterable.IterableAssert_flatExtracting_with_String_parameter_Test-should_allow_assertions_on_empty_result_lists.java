@Test public void should_allow_assertions_on_empty_result_lists(){
  assertThat(newArrayList(bart,lisa,maggie)).flatExtracting("children").isEmpty();
}
