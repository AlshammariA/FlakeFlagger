@Test public void convert_tuple_to_an_array(){
  Tuple tuple=new Tuple("Yoda",800,"Jedi");
  assertThat(tuple.toArray()).isEqualTo(array("Yoda",800,"Jedi"));
}
