@Test public void should_return_new_List(){
  ArrayList<String> list1=Lists.newArrayList();
  ArrayList<String> list2=Lists.newArrayList();
  assertThat(list2).isNotSameAs(list1);
  list1.add("abc");
  assertThat(list2).isEmpty();
}
