@Test public void should_create_tuple(){
  Tuple tuple=Assertions.tuple("Yoda",800,"Jedi");
  assertThat(tuple).isEqualTo(new Tuple("Yoda",800,"Jedi"));
}
