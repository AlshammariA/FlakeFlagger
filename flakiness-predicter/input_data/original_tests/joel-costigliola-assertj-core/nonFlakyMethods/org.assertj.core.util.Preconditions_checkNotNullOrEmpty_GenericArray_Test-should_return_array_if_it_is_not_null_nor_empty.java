@Test public void should_return_array_if_it_is_not_null_nor_empty(){
  String[] array=new String[]{"a"};
  String[] result=Preconditions.checkNotNullOrEmpty(array);
  assertThat(result).isEqualTo(array);
}
