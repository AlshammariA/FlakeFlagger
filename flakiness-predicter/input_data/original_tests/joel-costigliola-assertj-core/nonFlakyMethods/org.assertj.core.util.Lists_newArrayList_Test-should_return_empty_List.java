@Test public void should_return_empty_List(){
  ArrayList<String> list=Lists.newArrayList();
  assertThat(list).isEmpty();
}
