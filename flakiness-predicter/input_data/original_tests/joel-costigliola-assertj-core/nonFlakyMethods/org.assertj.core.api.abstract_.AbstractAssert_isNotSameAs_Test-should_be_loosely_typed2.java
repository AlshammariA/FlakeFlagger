@Test public void should_be_loosely_typed2(){
  List<? extends String> expected=new ArrayList<>();
  List<? extends String> actual=new ArrayList<>();
  Assertions.assertThat(actual).isNotSameAs(expected);
}
