@Test public void should_return_empty_List(){
  List<String> list=Lists.emptyList();
  assertThat(list).isEmpty();
}
