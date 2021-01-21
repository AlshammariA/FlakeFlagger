@Test public void should_return_empty_mutable_List(){
  ArrayList<String> list=Lists.newArrayList();
  assertThat(list).isEmpty();
  list.add("abc");
  assertThat(list).containsExactly("abc");
}
