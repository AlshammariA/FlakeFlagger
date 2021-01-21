@Test public void should_return_a_Collection_without_null_elements(){
  String[] array={"Frodo",null,"Sam",null};
  List<String> nonNull=nonNullElementsIn(array);
  assertArrayEquals(new String[]{"Frodo","Sam"},nonNull.toArray());
}
