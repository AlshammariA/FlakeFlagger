@Test public void should_throw_error_if_index_is_equal_to_size(){
  thrown.expectIndexOutOfBoundsException("Index should be between 0 and 1 (inclusive,) but was 2");
  list.get(2);
}
