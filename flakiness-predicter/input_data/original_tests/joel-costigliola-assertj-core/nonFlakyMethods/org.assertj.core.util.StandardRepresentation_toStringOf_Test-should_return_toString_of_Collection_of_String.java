@Test public void should_return_toString_of_Collection_of_String(){
  Collection<String> collection=newArrayList("s1","s2");
  assertEquals("[\"s1\", \"s2\"]",new StandardRepresentation().toStringOf(collection));
}
