@Test public void should_return_null_if_array_is_null(){
  final Object array=null;
  assertNull(Arrays.format(new StandardRepresentation(),array));
  assertNull(Arrays.format(array));
}
