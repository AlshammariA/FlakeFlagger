@Test public void should_return_null_if_iterator_is_null(){
  Iterator<?> elements=null;
  assertThat(Lists.newArrayList(elements)).isNull();
}
