@Test public void should_throw_error_if_args_array_is_null(){
  thrown.expect(NullPointerException.class);
  Object[] args=null;
  messageFormatter.format(null,null,"",args);
}
