@Test public void should_create_Assert_with_list_extended(){
  List<String> strings0=new ArrayList<>();
  List<? extends String> strings1=new ArrayList<>();
  Assertions.assertThat(strings0).isEqualTo(strings1);
  Assertions.assertThat(strings1).isEqualTo(strings0);
}
