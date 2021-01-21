@Test public void should_return_Set_containing_iterable_elements(){
  String[] array=new String[]{"A","b","C"};
  Iterable<String> iterable=Arrays.asList(array);
  HashSet<String> set=Sets.newHashSet(iterable);
  assertThat(set).containsOnly(array);
}
