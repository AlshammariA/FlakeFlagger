@Test public void should_return_object_if_it_is_not_null_nor_empty(){
  String object="4711";
  String result=Preconditions.checkNotNull(object);
  assertThat(result).isEqualTo(object);
}
