@Test public void should_create_tuple(){
  Tuple tuple=new Tuple("Yoda",800,"Jedi");
  assertThat(tuple).isEqualTo(new Tuple("Yoda",800,"Jedi"));
}
