@Test public void should_throw_NullPointerException_if_array_is_null(){
  thrown.expect(NullPointerException.class);
  String[] array=null;
  Preconditions.checkNotNullOrEmpty(array);
}
