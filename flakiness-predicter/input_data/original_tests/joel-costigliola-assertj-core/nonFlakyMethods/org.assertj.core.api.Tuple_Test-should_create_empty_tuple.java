@Test public void should_create_empty_tuple(){
  Tuple tuple=new Tuple();
  assertThat(tuple).isEqualTo(new Tuple());
}
